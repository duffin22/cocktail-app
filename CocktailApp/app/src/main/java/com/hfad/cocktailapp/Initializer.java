package com.hfad.cocktailapp;

import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by matthewtduffin on 31/07/16.
 */
public class Initializer {

    public Initializer() {
    }

    public static List<Cocktail> makeAllCocktails() {

        List<Cocktail> cocktails = new ArrayList<>();
        cocktails.add(makeCosmopolitan());
        cocktails.add(makeEspressoMartini());
        cocktails.add(makeFrenchMartini());
        cocktails.add(makeLongIslandIcedTea());
        cocktails.add(makeMojito());
        cocktails.add(makeOldFashioned());
        cocktails.add(makePinaColada());

        return cocktails;

    }

    public static Cocktail makeCosmopolitan() {
        List<MethodItem> meths = new ArrayList<>();
        meths.add(new MethodItem("Add all ingredients to a Boston shaker filled with ice.",1));
        meths.add(new MethodItem("Shake well and double strain into a chilled cocktail glass.",2));
        meths.add(new MethodItem("Place the lime wheel on the edge of the glass.",3));

        List<CocktailIngredient> ings = new ArrayList<>();
        ings.add(new CocktailIngredient("Vodka Citron",40,"ml",1,0));
        ings.add(new CocktailIngredient("Cointreau",15,"ml"));
        ings.add(new CocktailIngredient("Fresh Lime Juice",15,"ml"));
        ings.add(new CocktailIngredient("Cranberry Juice",30,"ml"));
        ings.add(new CocktailIngredient("Lime Wheel",1,"",0,1));

        return new Cocktail("Cosmopolitan","IBA Official Cocktail", S.CONTEMPORARY_CLASSICS ,meths, ings);
    }

    public static Cocktail makeEspressoMartini() {
        List<MethodItem> meths = new ArrayList<>();
        meths.add(new MethodItem("Add all ingredients to a Boston shaker filled with ice.",1));
        meths.add(new MethodItem("Shake well and double strain into a chilled cocktail glass.",2));
        meths.add(new MethodItem("Float coffee beans on top of the drink to garnish.",3));

        List<CocktailIngredient> ings = new ArrayList<>();
        ings.add(new CocktailIngredient("Vodka",50,"ml",1,0));
        ings.add(new CocktailIngredient("Sugar Syrup",10,"ml"));
        ings.add(new CocktailIngredient("Kahlua",10,"ml"));
        ings.add(new CocktailIngredient("Espresso",30,"ml"));
        ings.add(new CocktailIngredient("Coffee Beans",3,"",0,1));

        return new Cocktail("Espresso Martini","IBA Official Cocktail", S.NEW_ERA_DRINKS ,meths, ings);
    }

    public static Cocktail makeFrenchMartini() {
        List<MethodItem> meths = new ArrayList<>();
        meths.add(new MethodItem("Add all ingredients to a Boston shaker filled with ice.",1));
        meths.add(new MethodItem("Shake well and double strain into a chilled cocktail glass.",2));
        meths.add(new MethodItem("Squeeze oil from lemon peel into drink and place the peel in the glass.",3));

        List<CocktailIngredient> ings = new ArrayList<>();
        ings.add(new CocktailIngredient("Vodka",45,"ml",1,0));
        ings.add(new CocktailIngredient("Raspberry Liquer",15,"ml",1,0));
        ings.add(new CocktailIngredient("Pineapple Juice",15,"ml"));
        ings.add(new CocktailIngredient("Lemon Peel",1,"slice",0,1));


        return new Cocktail("French Martini","IBA Official Cocktail", S.NEW_ERA_DRINKS ,meths, ings);
    }

    public static Cocktail makeLongIslandIcedTea() {
        List<MethodItem> meths = new ArrayList<>();
        meths.add(new MethodItem("Add all ingredients (except cola) to a highball glass filled with ice.",1));
        meths.add(new MethodItem("Stir gently, then add cola.",2));
        meths.add(new MethodItem("Garnish with lemon twist.",3));

        List<CocktailIngredient> ings = new ArrayList<>();
        ings.add(new CocktailIngredient("Vodka",15,"ml",1,0));
        ings.add(new CocktailIngredient("Tequila",15,"ml",1,0));
        ings.add(new CocktailIngredient("White Rum",15,"ml",1,0));
        ings.add(new CocktailIngredient("Gin",15,"ml",1,0));
        ings.add(new CocktailIngredient("Triple Sec",15,"ml",1,0));
        ings.add(new CocktailIngredient("Lemon Juice",25,"ml"));
        ings.add(new CocktailIngredient("Sugar Syrup",30,"ml"));
        ings.add(new CocktailIngredient("Cola",1,"dash"));
        ings.add(new CocktailIngredient("Lemon Twist",1,"",0,1));


        return new Cocktail("Long Island Iced Tea","IBA Official Cocktail", S.CONTEMPORARY_CLASSICS ,meths, ings);
    }

    public static Cocktail makeMojito() {
        List<MethodItem> meths = new ArrayList<>();
        meths.add(new MethodItem("Muddle lime juice, sugar and mint in a highball.",1));
        meths.add(new MethodItem("Add the rum and fill with crushed ice.",2));
        meths.add(new MethodItem("Top up with soda water and garnish with lime wheel and a sprig of mint.",3));

        List<CocktailIngredient> ings = new ArrayList<>();
        ings.add(new CocktailIngredient("White Rum",40,"ml",1,0));
        ings.add(new CocktailIngredient("Lime Juice",30,"ml"));
        ings.add(new CocktailIngredient("Mint Sprigs",6,""));
        ings.add(new CocktailIngredient("White Sugar",2,"tsp"));
        ings.add(new CocktailIngredient("Soda Water",1,"dash"));
        ings.add(new CocktailIngredient("Mint Sprig",1,"",0,1));
        ings.add(new CocktailIngredient("Lime Wheel",1,"",0,1));


        return new Cocktail("Mojito","IBA Official Cocktail", S.CONTEMPORARY_CLASSICS ,meths, ings);
    }

    public static Cocktail makeOldFashioned() {
        List<MethodItem> meths = new ArrayList<>();
        meths.add(new MethodItem("Place sugar cube in an old-fashioned glass and saturate with bitters.",1));
        meths.add(new MethodItem("Add a splash of water and muddle until dissolved.",2));
        meths.add(new MethodItem("Fill the glass with ice and add the bourbon.",3));
        meths.add(new MethodItem("Stir for 30 seconds, then add ice until full.",4));
        meths.add(new MethodItem("Garnish with orange slice and cocktail cherry.",5));


        List<CocktailIngredient> ings = new ArrayList<>();
        ings.add(new CocktailIngredient("Bourbon",45,"ml",1,0));
        ings.add(new CocktailIngredient("Angostura Bitters",2,"dashes"));
        ings.add(new CocktailIngredient("Sugar Cube",1,"ml"));
        ings.add(new CocktailIngredient("Water",1,"splash"));
        ings.add(new CocktailIngredient("Orange Slice",1,"",0,1));
        ings.add(new CocktailIngredient("Cocktail Cherry",1,"",0,1));


        return new Cocktail("Old Fashioned","IBA Official Cocktail", S.THE_UNFORGETTABLES ,meths, ings);
    }

    public static Cocktail makePinaColada() {
        List<MethodItem> meths = new ArrayList<>();
        meths.add(new MethodItem("Add all ingredients to a blender and blend until smooth.",1));
        meths.add(new MethodItem("Pour into hurricane glass and garnish with cocktail cherry & pineapple slice.",2));
        meths.add(new MethodItem("(Alternatively, all ingredients can be shaken and served over ice).",3));

        List<CocktailIngredient> ings = new ArrayList<>();
        ings.add(new CocktailIngredient("White Rum",30,"ml",1,0));
        ings.add(new CocktailIngredient("Pineapple Juice",90,"ml"));
        ings.add(new CocktailIngredient("Coconut Milk",30,"ml"));
        ings.add(new CocktailIngredient("Cocktail Cherry",1,"",0,1));
        ings.add(new CocktailIngredient("Pineapple Slice",1,"",0,1));


        return new Cocktail("Pina Colada","IBA Official Cocktail", S.CONTEMPORARY_CLASSICS ,meths, ings);
    }

}
