public class SpeedCameraNetwork {
    private SpeedCamera[] speedCameras;

    public SpeedCameraNetwork(SpeedCamera[] speedCameras) {
        this.speedCameras = speedCameras;
    }

    public SpeedCamera[] getSpeedCameras() {
        return speedCameras;
    }

    public void setSpeedCameras(SpeedCamera[] speedCameras) {
        this.speedCameras = speedCameras;
    }

    public void addSpeedCamera(SpeedCamera speedCamera) {
        int checkRoad = speedCamera.getRoadNumber();
        boolean answer = true;
        for (int i = 0; i < speedCameras.length; i++) {
            checkRoad = speedCameras[i].getRoadNumber();
            answer = false;
        }
        if (answer) {
            SpeedCamera[] newSpeedCameras = new SpeedCamera[this.speedCameras.length + 1];
            for (int i = 0; i < speedCameras.length; i++) {
                newSpeedCameras[i] = speedCameras[i];
            }
            speedCameras = newSpeedCameras;
            speedCameras[speedCameras.length - 1] = speedCamera;
            System.out.println("The New Camera is Added Successfully");
        }
    }

    public void getIncreasedEnforcementRoads() {
        for (int i = 0; i < speedCameras.length; i++) {
            if (speedCameras[i].getOverSpeedCars() != null) {
                if (speedCameras[i].getOverSpeedCars().length > 200) {
                    System.out.println(speedCameras[i].getRoadNumber());
                }
            }
        }
    }

    public boolean isCarOverspeeded(String carId) {
        boolean answer = false;
        if (speedCameras != null) {
            for (int i = 0; i < speedCameras.length; i++) {
                String[] speedCars = speedCameras[i].getOverSpeedCars();
                if (speedCars != null) {
                    for (int j = 0; j < speedCars.length; j++) {
                        if (carId.equals(speedCars[j])) {
                            answer = true;
                            System.out.println(speedCameras[i].getCode());
                        }
                    }
                }
            }
        }
        return answer;
    }

    public void TheTowMaxSpeedsFromAll() {
        if (this.speedCameras != null) {
            for (int i = 0; i < speedCameras.length; i++) {
                this.speedCameras[i].TheTowMaxSpeed();
            }
        }
    }


}
