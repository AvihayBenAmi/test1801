import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SpeedCamera speedCamera = new SpeedCamera("1a", 1, 60, null);
        System.out.println(speedCamera.addCar("123456", 70));
        System.out.println("car added");
        System.out.println("------------------------------------------------------------");

        System.out.println("creating network");
        String[] overSpeedCars1 = new String[251];
        String[] overSpeedCars2 = new String[251];

        Random random = new Random();
        for (int i = 0; i< 250 ; i++){
            int carNumber1 = random.nextInt(11111, 9999999);
            int carNumber2 = random.nextInt(11111, 9999999);

            overSpeedCars1[i] = String.valueOf(carNumber1);
            overSpeedCars2[i] = String.valueOf(carNumber2);

        }
        overSpeedCars1[250] = "1855555";
        overSpeedCars2[250] = "1855555";

        SpeedCamera[] speedCameras = {
                new SpeedCamera("aa1", 30, 50, overSpeedCars1),
                new SpeedCamera("aa2", 20, 60, overSpeedCars2),
                new SpeedCamera("aa3", 10, 70, null),
                new SpeedCamera("aa4", 5, 50, null),
                new SpeedCamera("aa5", 3, 40, null)

        };

        SpeedCameraNetwork speedCameraNetwork = new SpeedCameraNetwork(speedCameras);
        System.out.println("you have " + speedCameraNetwork.getSpeedCameras().length + " in your network");
        System.out.println("trying to add existing camera");
        speedCameraNetwork.addSpeedCamera(new SpeedCamera("aa3", 10, 70, null));
        System.out.println("you have " + speedCameraNetwork.getSpeedCameras().length + " in your network");
        System.out.println("------------------------------------------------------------");
        System.out.println("printing increased enforcement roads");
        speedCameraNetwork.getIncreasedEnforcementRoads();
        System.out.println("------------------------------------------------------------");
        System.out.println("checking if car is overSpeed");
        speedCameraNetwork.isCarOverspeeded("1855555");
        System.out.println("------------------------------------------------------------");
        System.out.println("the tow max");
        speedCameraNetwork.TheTowMaxSpeedsFromAll();


    }//
}
