package chapter05Project2;

public class Runner {

	public static void main(String[] args) {
		System.out.println("Creating counter obect to test.");
		Counter count = new Counter();


		System.out.println("Testing the printing method.");
		count.printValue();


		System.out.println("Checking the return value method.");
		if (count.currentValue==count.getCurrentValue()){
			System.out.println("Seems like it is returning what it should.");
		}else{
			System.err.print("Okay we are having a problem over here.");
		}


		System.out.println();
		
		System.out.println("Testing to see what if the add by 1 and add by 10 methods work correctely.");
		System.out.println("If the add by 1 works correctely then the value of the count should become " + (count.getCurrentValue()+1));
		int tempStorage = count.currentValue;
		if (count.increaseByOne()){		
		}else{
			System.err.println("Seems like we are overflowing already... this should not happen");
		}
		count.printValue();
		if(tempStorage+1 == count.currentValue){
			System.out.println("Seems like it is correct");
		} else {
			System.err.println("Okay something is wrong here...");
		}


		tempStorage = count.currentValue;
		System.out.println("If the add by 10 works correctely then the value of the count should become " + (count.getCurrentValue()+10));
		if (count.increaseByTen()){			
		}else{
			System.err.println("Seems like we are overflowing already... this should not happen");
		}
		count.printValue();
		if(tempStorage+10 == count.currentValue){
			System.out.println("Seems like it is correct");
		} else {
			System.err.println("Okay something is wrong here...");
		}

		System.out.println();
		


		System.out.println("Testing to see what if the decrease by 1 and decrease by 10 methods work correctely.");
		System.out.println("If the decrease by 1 works correctely then the value of the count should become " + (count.getCurrentValue()-1));
		tempStorage = count.currentValue;
		if (count.decreaseByOne()){		
		}else{
			System.err.println("We are becoming negative already??? this should not happen");
		}
		count.printValue();
		if(tempStorage-1 == count.currentValue){
			System.out.println("Seems like it is correct.");
		} else {
			System.err.println("Okay something is wrong here...");
		}


		tempStorage = count.currentValue;
		System.out.println("If the decrease by 10 works correctely then the value of the count should become " + (count.getCurrentValue()-10));
		if (count.decreaseByTen()){			
		}else{
			System.err.println("We are becoming negative already??? this should not happen");
		}
		count.printValue();
		if(tempStorage-10 == count.currentValue){
			System.out.println("Seems like it is correct.");
		} else {
			System.err.println("Okay something is wrong here...");
		}



		System.out.println();
		
		System.out.println("Now lets see if the decrease methods can make the count become negative.");
		if (count.decreaseByOne()){	
			System.err.println("Okay we should not be able to get here.... something might be wrong.");
		}else{
			System.out.println("Okay so it told us that count would've become negative if we where to do this, so far so good.");
			
		}
		count.printValue();
		if(count.currentValue<0){
			System.err.println("BIG trouble, count became negative where it should not be able to become negative!");
		} else {
			System.out.println("The method to decrease by 1 works.");
		}
		
		if (count.decreaseByTen()){	
			System.err.println("Okay we should not be able to get here.... something might be wrong.");
		}else{
			System.out.println("Okay so it told us that count would've become negative if we where to do this, so far so good.");
			
		}
		count.printValue();
		if(count.currentValue<0){
			System.err.println("BIG trouble, count became negative where it should not be able to become negative!");
		} else {
			System.out.println("The method to decrease by 10 works.");
		}
		
		System.out.println();
		System.out.println("So far everything still works, now there are a couple things still to test:");
		System.out.println("The overflowing should be stopped in time by the increase methods");
		System.out.println("The setToZero method also still needs to be tested");
		System.out.println();
		
		
		System.out.println("Okay now trying to increase the value of the counter till " + (Integer.MAX_VALUE-10) + " which is 10 below the maximum value");
		while ((Integer.MAX_VALUE-100)>count.currentValue){
			count.increaseByTen();
		}
		while ((Integer.MAX_VALUE-10)>count.currentValue){
			count.increaseByOne();
		}
		count.printValue();
		
		System.out.println("Okay, if we now where to add 10 we should be stopped due to overflow");
		if (count.increaseByTen()){
			System.err.println("Hmmmmm it was succesful, that should not happen....");
		}else{
			System.out.println("There we go, we got ourselves an overflow like we would like");
		}
		
		
		System.out.println("Now we need to check for the add 1 overflow... this means getting the current count to " + (Integer.MAX_VALUE-1));
		while ((Integer.MAX_VALUE-1)>count.currentValue){
			count.increaseByOne();
		}
		count.printValue();
		
		System.out.println("Now lets see if we can add by one...");
		if (count.increaseByOne()){
			System.err.println("Okay we were able to increase... thats incorrect");
		}else{
			System.out.println("Whop overflow achieved, things are going quite well :)");
		}
		
		
		System.out.println();
		System.out.println("Now last test is to see if we can set it to 0, so lets do that.");
		count.setToZero();
		count.printValue();
		if (count.currentValue==0){
			System.out.println("Even that was succesful, looks like it is celebrating time!");
		}else{
			System.err.println("Awwww... the last one is going wrong :'(");
		}
		
		
		


	}

}
