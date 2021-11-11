package model;

public class CargoLorry extends Vehicle{
    int [] reservedSlotCargoLorry={5,6,7,8,9,10,11};
    String [] parked={"null","null","null","null","null","null","null"};
    int slot;
    String passValue;


    @Override
    public void park(String vehicleNumber, String vehicleType) {
        if (parked[slot].equals("null")){
            parked[slot]=vehicleNumber;
           // System.out.println("add.."+slot);
        }else{
            //System.out.println("All Ready Park");
        }
    }

    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {
        for (int i=0;i<parked.length;i++){
            if (vehicleNumber.equals(parked[i])){
                parked[i]="null";
                slot=i;
                break;
            }else{
                System.out.println("Not Leaving");
            }
        }

    }

    @Override
    public String setSlot(String vehicleNumber, String vehicleType) {

        for (int i = 0; i < reservedSlotCargoLorry.length; i++) {

            for (int j = 0; j < reservedSlotCargoLorry.length; j++) {
                if (parked[j].equals(vehicleNumber)) {
                    passValue = "Parked";
                    System.out.println("Parked..slot");
                    return passValue;
                }
                System.out.println("loop :" + j);
                if (j == 5) {
                    break;
                }
            }

            if (parked[i].equals("null")) {
                System.out.println("view slot " + reservedSlotCargoLorry[i]);
                slot = i;
                passValue = Integer.toString(reservedSlotCargoLorry[slot]);
                break;
            }

        }
        return passValue;
    }
}
