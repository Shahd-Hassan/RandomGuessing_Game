import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Rand {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("/////////////////---> WELCOME TO 'The Random Game' << <------/////////////////////////");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("                     -->The Game is Simple," + "\n" + "               We have a hidden random number in the system," + "\n" + "        all you have to do is guess that number !. It's that easy...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("You Will be asked repeatedly to enter a number, if this number is the Hidden number we have," + "\n" + "then CONGRATS! you won, if it is not then don't worry we will display a message to tell you" + "\n" + "            whether you are close from this number to get to it.");
        System.out.println("                       It Is So Much FUN!!!");
        System.out.println();
        System.out.println("WARNING:: ONLY POSITIVE INTEGERS ARE ALLOWED!");
        System.out.println();
        System.out.println("We have an option if you would like to have a preview about your attempts!");
        System.out.println("Choose 1 if: (yes, i want to see my review).");
        System.out.println("Choose 2 if: (no, i just want to have fun). ");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        System.out.println("Ready to start Guessing?");
        System.out.println();
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100);
        //System.out.println("Random Integer: " + rand_int1);
        try {
            int attempts = 0;
            List<Integer> guesslist = new ArrayList<>();
            boolean correct = false;
            while (!correct) {
                System.out.println("Enter a number: ");
                int guess = input.nextInt();
                attempts += 1;
                if(guess<0){
                    throw new IllegalArgumentException("Please Enter Only Positive Numbers");
                }
                guesslist.add(guess);
                if (guess == rand_int1) {
                    correct = true;
                    System.out.println("CONGRATULATIONS!!! YOU WON ");
                    System.out.println("would you like to preview ?");
                    int rev = input.nextInt();
                    switch (rev) {
                        case 1:
                            try {
                            System.out.println("Please Enter Your UserName: ");
                            String name = input.next();
                            System.out.println(guesslist);
                                double sum = 0.0, StandardDeviation = 0.0;
                                for (double num : guesslist) {
                                    sum += num;
                                }
                                double mean = sum / guesslist.size();
                                for (double num : guesslist) {
                                    StandardDeviation += Math.pow(num - mean, 2);
                                }
                                double dev = Math.sqrt(StandardDeviation / guesslist.size());


                                System.out.println(sum);
                                System.out.println(mean);
                                System.out.println(dev);


                                try {
                                    FileWriter writer = new FileWriter("C://Users//shahd's Laptop//Desktop//Assignment 2 _BMI_Rand//src/GuessReport.txt", true);
                                    writer.write("\n" + "This Is Your Preview: " + "\n");
                                    writer.write("UserName : " + name + "\n");
                                    writer.write("The Number Of your Attempts: " + attempts + "\n");
                                    writer.write("The Standard Deviation of your Trials: " + dev + "\n");
                                    writer.write("Thanks For Playing!!! ");
                                    writer.close();
                                    System.out.println("Data Successfully Added to file.");
                                } catch (IOException e) {//error in file
                                    System.out.println("An error occurred while appending double to file: " + e.getMessage());
                                    e.printStackTrace();
                                } catch (InputMismatchException e) {//error in entering string instead of number
                                    System.out.println("Invalid input. Please enter a valid integer.");
                                } catch (IllegalArgumentException e) {//error in entering negative numbers
                                    System.out.println(e.getMessage());
                                }
                            }catch (ArithmeticException e) {//error from calculations
                                System.out.println("An arithmetic exception occurred: " + e.getMessage());
                            } catch (InputMismatchException e) {//error in entering string instead of number
                                System.out.println("Invalid input. Please enter a valid integer.");
                            } catch (NumberFormatException e) {//error in entering numbers in userName instead of strings
                                System.out.println(e.getMessage());
                            }

                            break;
                        case 2:
                            try {
                                System.out.println("Thanks For Playing Our Game! Hope You Had Fun!!! ");
                                break;
                            } catch (InputMismatchException e) {//error in entering string instead of number
                                System.out.println("Invalid input. Please enter a valid integer.");
                            } catch (IllegalArgumentException e) {//error in entering negative numbers
                                System.out.println(e.getMessage());
                            }
                        default:
                            System.out.println("Please Enter A Valid Number!!!");


                    }

                } else if (guess < rand_int1) try {
                    System.out.println("OOPS, PLEASE TRY GUESSING A LARGER NUMBER ");

                } catch (InputMismatchException e) {//error in entering string instead of number
                    System.out.println("Invalid input. Please enter a valid integer.");
                } catch (IllegalArgumentException e) {//error in entering negative numbers
                    System.out.println(e.getMessage());
                }


                else try {
                        System.out.println("YOU ARE CLOSE, TRY GUESSING A SMALLER NUMBER");
                    } catch (InputMismatchException e) {//error in entering string instead of number
                        System.out.println("Invalid input. Please enter a valid integer.");
                    } catch (IllegalArgumentException e) {//error in entering negative numbers
                        System.out.println(e.getMessage());
                    }

            }

        } catch (InputMismatchException e) {//error in entering string instead of number
            System.out.println("Invalid input. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {//error in entering negative numbers
            System.out.println(e.getMessage());
        }
    }
    }

