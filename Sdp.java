
import Iterator.ChannelCollection;
import Iterator.*;
import Iterator2.*;
import Singleton.*;
import FactoryMethod.*;
import Builder.*;
import Prototype.*;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

public class Sdp {
    public static void main(String[] args){

        System.out.println("Software Development Patterns");


        /*
        Singleton implementation test
         */

        SingletonLazyExample sle = SingletonLazyExample.getInstance();
        SingletonLazyExample sle2 = SingletonLazyExample.getInstance();

        SingletonEagerExample see = SingletonEagerExample.getInstance();
        SingletonEagerExample see2 = SingletonEagerExample.getInstance();

        System.out.println("Singleton Lazy Example: " + sle.getInvoke());
        System.out.println("Singleton Lazy Example (2nd invoke): " + sle2.getInvoke());

        System.out.println("Singleton Eager Example: " + see.getInvoke());
        System.out.println("Singleton Lazy Example (2nd invoke): " + see2.getInvoke());



        /*
        Factory Method implementation test
        */

        FactoryMethodExample shapeFactory = new FactoryMethodExample();
        //get an object of Circle and call its draw method.
        FactoryMethod.Shape shape1 = shapeFactory.getShape("CIRCLE");
        //call draw method of Circle
        shape1.draw();
        //get an object of Rectangle and call its draw method.
        FactoryMethod.Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //call draw method of Rectangle
        shape2.draw();
        //get an object of Square and call its draw method.
        FactoryMethod.Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of circle
        shape3.draw();



        /*
        Iterator implementation test
        */

        ChannelCollection channels = populateChannels();
        ChannelIterator baseIterator = channels.iterator(ChannelTypeEnum.ALL);
        while(baseIterator.hasNext()){
            Channel c = baseIterator.next();
            System.out.println(c.toString());
        }


        ChannelIterator englishIterator = channels.iterator(ChannelTypeEnum.ENGLISH);
        while (englishIterator.hasNext()) {
            Channel c = englishIterator.next();
            System.out.println("English iterators" + c.toString());
        }


        /*
        Iterator2 implementation test
         */

        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }


         /*
        Builder implementation test
         */

        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());


          /*
        Prototype implementation test
         */

        Prototype.Shape clonedShape = (Prototype.Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Prototype.Shape clonedShape2 = (Prototype.Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Prototype.Shape clonedShape3 = (Prototype.Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());

    }



    /*
    Helper methods
     */

    private static ChannelCollection populateChannels() {
        ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(99.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(100.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(101.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(102.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(103.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(105.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(106.5, ChannelTypeEnum.FRENCH));
        return channels;
    }
}
