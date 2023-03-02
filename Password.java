public class Password {
    public Password() {}
    public int checkStrongPassword(String password){
        // if empty or null the minimum change will be 6
        if(password.isEmpty()) return 6;
        boolean upper=false,lower=false,digit=false;
        int minimumChange=0,length=password.length(),repeating=0;

        // check if we have digit, upper-lowerCase letter
        for(int i=0; i<password.length()&& i<20; i++){
            char character=password.charAt(i);
            if(Character.isUpperCase(character)) upper=true;
            if(Character.isLowerCase(character)) lower=true;
            if(Character.isDigit(character)) digit=true;
            if(upper&&lower&&digit) break;
        }

        //add to number of operations
        if(!upper) minimumChange++;
        if(!lower) minimumChange++;
        if(!digit) minimumChange++;

        //check for 3 repeating characters
        for(int i=0; i<length-2 && i<20; i++){
            if(password.charAt(i)==password.charAt(i+1) && password.charAt(i+1)==password.charAt(i+2)){
                repeating++;
                i+=2;
            }
        }
        // case when length smaller than 6, we need to add elements to get to 6
        if(length<6){
            minimumChange=minimumChange==0?repeating:minimumChange;
            //if short password < missing characters
            if(length+minimumChange>6){
              minimumChange=6-length+(length+minimumChange)-6;
            }
            else
                minimumChange=6-length;
        }else {
            //case when length >= 6
            minimumChange +=repeating>minimumChange? repeating-minimumChange:0;
            // case when length>20, we delete all surplus
            if (length > 20) {
                minimumChange += length - 20;
            }
        }
        return minimumChange;

    }

}

