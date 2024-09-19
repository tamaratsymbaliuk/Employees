package employees;

public interface Chef {
    final String favoriteFood = "hamburger";

    // default methods are not required to be implemented

    default void cook(String food){
        System.out.println("I am not cooking " + food);
    };

    default String cleanUp() {
        return "I'm done cleaning up";
    }
    default String getFavoriteFood() {
        return favoriteFood;
    }
}
