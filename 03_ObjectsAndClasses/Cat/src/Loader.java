
public class Loader
{
    public static void main(String[] args)
    {
        Cat myrka = new Cat();
        Cat neko = new Cat();
        Cat koshka = new Cat();
        Cat godzilla = new Cat();
        Cat kazuma = new Cat();

        System.out.println("Вес до кормёжки : " + myrka.getWeight());
        myrka.feed(150.0);
        System.out.println("Вес после кормёжки : " + myrka.getWeight());

        System.out.println("Вес до кормёжки : " + neko.getWeight());
        neko.drink(100.0);
        System.out.println("Вес после кормёжки : " + neko.getWeight());

        while (!koshka.getStatus().equals("Dead"))
            koshka.meow();
        System.out.println(koshka.getStatus());

        while (!godzilla.getStatus().equals("Exploded"))
            godzilla.feed(150.0);
        System.out.println(godzilla.getStatus());
    }
}