public class SpeedCamera {
    private String code;
    private int roadNumber;
    private int maxSpeed;
    private String[] overSpeedCars;

    public SpeedCamera(String[] overSpeedCars) {
        this.code = code;
        this.roadNumber = roadNumber;
        this.maxSpeed = maxSpeed;
        this.overSpeedCars = overSpeedCars;
    }

    public SpeedCamera(String code, int roadNumber, int maxSpeed, String[] overSpeedCars) {
        this.code = code;
        this.roadNumber = roadNumber;
        this.maxSpeed = maxSpeed;
        this.overSpeedCars = overSpeedCars;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getRoadNumber() {
        return roadNumber;
    }

    public void setRoadNumber(int roadNumber) {
        this.roadNumber = roadNumber;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String[] getOverSpeedCars() {
        return overSpeedCars;
    }

    public void setOverSpeedCars(String[] overSpeedCars) {
        this.overSpeedCars = overSpeedCars;
    }

    public boolean addCar(String carId, int carSpeed) {
        boolean answer = false;
        if (this.overSpeedCars != null) {
            String[] newOverSpeedCars = new String[this.overSpeedCars.length + 1];
            for (int i = 0; i < this.overSpeedCars.length; i++) {
                newOverSpeedCars[i] = overSpeedCars[i];
            }
            this.overSpeedCars = newOverSpeedCars;
            if (carSpeed > getMaxSpeed()) {
                this.overSpeedCars[this.overSpeedCars.length - 1] = carId + "" + carSpeed;
                answer = true;
            }
        }
        return answer;
    }

    public String[] TheTowMaxSpeed() {
        String max1 = null;
        String max2 = null;
        String[] towMax = {max1, max2};
        int location = 0;
        if (overSpeedCars != null) {
            for (int i = 0; i < overSpeedCars.length; i++) {
                for (int j = 0; j < overSpeedCars.length; j++) {
                    if (Integer.parseInt(overSpeedCars[i]) < Integer.parseInt(overSpeedCars[j])) {
                        max1 = (overSpeedCars[j]);
                        location = j;
                    }
                    else{
                        max1=overSpeedCars[i];
                    }
                }
            }
        }
        if(overSpeedCars!=null) {
            for (int i = 0; i < overSpeedCars.length; i++) {
                if (overSpeedCars[i] != max1) {
                    for (int j = 0; j < overSpeedCars.length; j++) {
                        if (Integer.parseInt(overSpeedCars[i]) < Integer.parseInt(overSpeedCars[j])) {
                            max2 = (overSpeedCars[j]);
                            location = j;
                        }
                    }
                }
            }
        }
        if(max1!=null&&max2!=null) {
            System.out.println("The max speeder is= " + max1 + "The Second max speeder is " + max2);
        }
        return towMax;
    }
}
