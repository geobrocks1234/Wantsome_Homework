package week2;
public class Methods {
    private int[] array;
    private int[] tempMergArr;
    private int length;
    // Exercise 1 A
    private static String xTimes(String a, int b) {
        String s = "";
        for (int i = 0; i < b; i++) {
            s += a;
        }
        return s;
    }

    //Exercise 2 A
    private static int sumSquares(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    // Exercise 1 Homework
    private static void decimalToBinary(int n) {
        int bin[] = new int[120];
        int index = 0;
        while (n > 0) {
            bin[index++] = n % 2;
            n = n / 2;
        }
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(bin[i]);
        }
    }

    //Exercise 2 Homework
    private static void doubleStringRep(double[] doubles) {
        String result = "(";
        for (int i = 0; i <doubles.length; i++) {
            result = result+String.format("%.02f", doubles[i])+",";
        }
        result = result.substring(0,result.length()-2);
        result = result+")";
        System.out.println(result);
    }

    private static String integerStringRep(int[] arr) {
        String result = "(";
        for (int i = 0; i <arr.length; i++) {
            result = result+arr[i]+",";
        }
        result = result.substring(0,result.length()-1);
        result = result+")";
        return result;
    }

    //Exercise 3 Homework
    private static void returnOddNUmbers(int[] param){
        String result ="(";
        for(int i=0;i<param.length;i++){
            if(param[i]%2!=0){
                result =result+param[i]+",";
            }
        }
        result = result.substring(0,result.length()-1);
        System.out.println(result+")");
    }

    //Exercise 4 Homework
    private static void returnConsecutiveOrder(int[] param){
        int i =0;
        String result = "";
        while(i<param.length){
            int val = param[i];
            int j = i+1;
            int count =1;
            while(j<param.length && val==param[j]){
                count++;
                j++;
            }
            if(count>1){
                result += val+",";
                //System.out.println();
                i=j;
            }
            else{
                i++;
            }
        }
        result = result.substring(0,result.length()-1);
        System.out.println(result);
    }

    //Exercise 5 Homework
    private static void checkArraySorted(int[] param){
        boolean isSorted =true;
        for(int i=0; i<param.length-1;i++) {
            if (param[i] > param[i + 1]) {
                System.out.println("The array given is not sorted!");
                isSorted = false;
                break;
            }
        }
        if(isSorted) {
            System.out.println("The array given is sorted!");
        }
    }

    //Exercise 6 Bonus
    private static String numberBase(int n, int b) {
        String result = "";
        while (n > 0) {
            int r = n % b;
            if (r > 9) {
                char firstLetter = 'A';
                int dif = r - 10;
                result = (char) (firstLetter + dif) + result;
            } else {
                result = r + result;
            }
            n /= b;
        }
        return result;
    }

    //Exercise 7 Bonus
    private static int binaryToDecimal(String numberInBinary) {
        int decimal = 0;
        int power = 1;
        for (int i = (numberInBinary.length() - 1); i >= 0; i--) {
            char c = numberInBinary.charAt(i);
            decimal = decimal + (Integer.parseInt(c + "") * power);
            power = power * 2;
        }
        return decimal;
    }

    //Exercise 1 Algorithms
    private static String insertionSort(int[] arrayInt) {
        for (int i = 1; i < arrayInt.length; i++) {
            int value = arrayInt[i];
            int j = i - 1;
            while (j >= 0 && arrayInt[j] > value) {
                arrayInt[j + 1] = arrayInt[j];
                j = j - 1;
            }
            arrayInt[j + 1] = value;
        }
        String result = "{";
        for(int i=-0; i< arrayInt.length;i++) {
            result = result+arrayInt[i]+",";
        }
        result =result.substring(0,result.length()-1);
        result = result+"}";
        return result;
    }

    //Exercise 2 Algorithms a)
    private static void binarySearch(int[] sortedArray, int input) {
        int first = 0;
        int last = sortedArray.length-1;
        boolean result=false;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (sortedArray[mid] < input) {
                first = mid + 1;
            } else if (sortedArray[mid] > input) {
                last = mid - 1;
            } else if (sortedArray[mid] == input) {
                result=true;
                break;
            }
        }
        String result2 = "{";
        for(int i=-0; i< sortedArray.length;i++) {
            result2 = result2+sortedArray[i]+",";
        }
        result2 =result2.substring(0,result2.length()-1);
        result2 = result2+"}";
        if(result) {
            System.out.println("The input " + input + " was found in the array "+result2+".");
        } else {
            System.out.println("The input " + input + " was not found in the array "+result2+".");
        }
    }

    //Exercise 2 Algorithms b)
    private static int binarySearchRecursively(int[] sortedArray, int input, int first, int last) {
        int mid = (first + last) / 2;

        if (last < first) {
            return -1;
        }
        if (input == sortedArray[mid]) {
            return mid;
        } else if (input < sortedArray[mid]) {
            return binarySearchRecursively(sortedArray, input, last, mid - 1);
        } else {
            return binarySearchRecursively(sortedArray, input, mid + 1, last);
        }
    }

    //Exercise 3 Algorithms
    public static int[] merge(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
        {
            if (a[i] < b[j])
            {
                answer[k] = a[i];
                i++;
            }
            else
            {
                answer[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length)
        {
            answer[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length)
        {
            answer[k] = b[j];
            j++;
            k++;
        }
        return answer;
    }

    //Exercise 4 Bonus
    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }

    public static void main (String[]args){
        //Exercise 1A
        System.out.println("Exercise 1A (param: Abs and 4)");
        System.out.println(xTimes("Abc", 4));
        //Exercise 2A
        System.out.println("Exercise 2A (param: 5)");
        System.out.println(sumSquares(5));
        //Exercise 1 Homework
        System.out.println("Binary representation for 10 is: ");
        decimalToBinary(10);
        System.out.println("\n");
        System.out.println("Binary representation for 127 is: ");
        decimalToBinary(127);
        //Exercise 2 Homework
        double[] doubles = {1.21212, 3.5121212, 2.212121, 0.612121, 3.512121, 8.5212121, 1.21212121};
        System.out.println("\nString representation (format by 2 decimals) for the array {1.21212, 3.5121212, 2.212121, 0.612121, 3.512121, 8.5212121, 1.21212121} is:");
        doubleStringRep(doubles);
        //Exercise 3 Homework
        int[] param = {1, 4, 4, 4, 5, 7, 8, 7, 2, 2, 9, 9};
        System.out.println("The odd numbers from the array {1, 4, 4, 5, 7, 8, 7, 2, 2, 9, 9} are: ");
        returnOddNUmbers(param);
        //Exercise 4 Homework
        System.out.println("The numbers in the array {1, 4, 4, 5, 7, 8, 7, 2, 2, 9, 9} that appear on consecutive positions are:");
        returnConsecutiveOrder(param);
        //Exercise 5 Homework
        System.out.println("Check if the array {1, 4, 4, 5, 7, 8, 7, 2, 2, 9, 9} is sorted.");
        checkArraySorted(param);
        //Exercise 6 Bonus
        System.out.println("The number 10 in base 8 is: "+numberBase(10, 8));
        System.out.println("The number 47 in base 16 is: "+numberBase(47, 16));
        //Exercise 7 Bonus
        System.out.println("Binary representation 101 converted in base 2 is: "+binaryToDecimal("101"));
        //Exercise 1 Algorithms
        int[] input = {1,5,4,2,3};
        System.out.println("The sorted array of {1,5,4,2,3} is: "+insertionSort(input));
        //Exercise 2 Algorithms a)
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        binarySearch(arr, 11);
        //Exercise 2 Algorithms b)
        int first = 0;
        int last = arr.length-1;
        int inputR = 5;
        if(binarySearchRecursively(arr,5,first,last)>=first && binarySearchRecursively(arr,inputR,first,last)<=last){
            System.out.println("The input "+inputR+" was found in the sorted array!");
        } else {
            System.out.println("The input "+inputR+" was not found in the array!");
        }
        //Exercise 3 Algorithms
        int[] a = {1,2,5,9};
        String aRep = integerStringRep(a);
        int[] b = {4,6,7,10,25};
        String bRep = integerStringRep(b);
        int[] c = merge(a,b);
        String cRep = integerStringRep(c);
        System.out.println("The array "+aRep+" merged with the array "+bRep+" has the result: "+cRep+".");
        //Exercise 4 Bonus
        int[] inputArr = {105,36,11,89,7,99,4,12,77,152};
        Methods mms = new Methods();
        mms.sort(inputArr);
        System.out.println("The result of the array {105,36,11,89,7,99,4,12,77,152} sorted with merge sort algorithm is: ");
        for(int i:inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
        //Exercise with ChessBoard solved with array
        System.out.println("Exercise with ChessBoard solved with array: ");
        NewChessBoard.newKnightMoves(1,4);
    }
}

