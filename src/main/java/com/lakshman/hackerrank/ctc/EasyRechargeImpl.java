package com.lakshman.hackerrank.ctc;

import java.math.BigDecimal;
import java.util.*;

/**
 * Create a Configuration based question answering system for user interaction(close-ended).
 * We would like to collect information from the user through mobile phones in different stages of the customer
 * journey. The customer journey may change frequently or may be assigned depending upon the acquisition
 * channel. Thus we need a unified system that can capture user answers based on the configuration it has.
 * The types of questions are
 * ● Optional
 * ● Text fields
 * ● Yes or No
 * The optional questions and Yes/No question will decide what question will be asked next. The text fields
 * question will be used later to store the user information. The text fields may have validation.
 * User Journey
 * Questions For existing User
 * A. Q: What would you like to do?
 * a. A: Press 1 to Check Balance
 * i. Msg: Your balance is 100 Rs.
 * 1. If the balance is < 200 then
 * a. Would you like to recharge?
 * i. A: Yes --> take user to recharge menu.
 * ii. A: No to exit
 * <p>
 * 2. Else (if the balance is > 200) Press OK to exit
 * <p>
 * b. A: Press 2 Recharge
 * i. We have following bundles you can use, choose one
 * 1. 50p for 1 minute call. 400 Rs per month
 * 2. 25p for 1 minute call. 600 Rs per month
 * 3. 1Rs for 1 minute call. Recharge arbitrary money
 * a. A: Text Field (Validate for recharge amount <0 and >10000)
 * i. Valid case: Recharge successfully
 * ii. Invalid case: You can not recharge with a specific amount. Please re-enter the amount.
 * <p>
 * Questions For New User
 * 1. Q: Welcome to Easy Recharge. Please enter your phone number to continue.
 * a. A: Text Field: (Basic mobile number validation)
 * i. Success: Register customer and continue; Generate and save the OTP in memory
 * ii. Failure: Show error and display the same question
 * <p>
 * 2. Q: Please Enter your OTP sent to you
 * a. A: Text field: (4 digit number)
 * i. Success: Load existing customer question config and show those question.
 * ii. Failure: Your OTP is invalid! Press 1 to re-enter, Press 2 to re-generate
 * 1. A: 1, take to previous enter your OTP flow
 * 2. A: 2, take to generate OTP flow and show the text field
 *
 *
 * @asked goscale June'18
 */

class TestClass {

    public static void main(String args[]) {
        EasyRechargeController cmdFrontController = new EasyRechargeCmdFrontController();
        cmdFrontController.startEasyRechargeJourney();
    }
}

interface EasyRecharge {
    boolean isUserExists(Long mobileNumber);

    void createNewUser(Long mobileNumber);

    void generateOTP(Long mobileNumber);

    boolean validateOtp(Long mobileNumber, String otpInput);

    BigDecimal getBalanceByMobileNumber(Long mobileNumber);

    void updateTariffPlan(TariffPlan tariffPlan, Long mobileNumber);

    void rechargeBalance(Long mobileNumber, int amount);
}

public class EasyRechargeImpl implements EasyRecharge {

    private final Map<Long, User> usersMap;
    private final Map<Long, Integer> unRegisteredUsersMap;
    private Random random;

    public EasyRechargeImpl() {
        usersMap = new HashMap<>();
        unRegisteredUsersMap = new HashMap<>();
        random = new Random();
    }

    @Override
    public boolean isUserExists(final Long mobileNumber) {
        return usersMap.containsKey(mobileNumber);
    }

    @Override
    public void createNewUser(final Long mobileNumber) {
        final User newUser = new User(mobileNumber);
        newUser.setBalance(new BigDecimal(100));
        newUser.setPlan(TariffPlan.PLAN_1RS);

        usersMap.put(mobileNumber, newUser);
    }

    @Override
    public void generateOTP(Long mobileNumber) {
        // generate value between 1000 to 9999 four digit number
        int otp = random.nextInt(8999) + 1000;

        // for testing purpose
        System.out.println("Generated OTP :: " + otp);

        unRegisteredUsersMap.put(mobileNumber, otp);
    }

    @Override
    public boolean validateOtp(Long mobileNumber, String otpInput) {
        boolean result = false;

        try {
            if (unRegisteredUsersMap.containsKey(mobileNumber)) {
                result = unRegisteredUsersMap.get(mobileNumber).equals(Integer.parseInt(otpInput));
            }
        } catch (NumberFormatException ne) {
            result = false;
        }

        return result;
    }


    @Override
    public BigDecimal getBalanceByMobileNumber(Long mobileNumber) {
        return usersMap.get(mobileNumber).getBalance();
    }

    @Override
    public void updateTariffPlan(TariffPlan tariffPlan, Long mobileNumber) {
        usersMap.get(mobileNumber).setPlan(tariffPlan);
    }

    @Override
    public void rechargeBalance(Long mobileNumber, int amount) {
        User user = usersMap.get(mobileNumber);
        user.setBalance(user.getBalance().add(new BigDecimal(amount)));
    }
}

class ValidationUtil {

    private ValidationUtil() {
    }

    public static boolean isValidMobileNumber(final String input) {
        boolean result = false;

        if (input != null && input.length() == 10) {

            try {
                Long.parseLong(input);
                result = true;
            } catch (NumberFormatException ne) {
                result = false;
            }
        }

        return result;
    }

    public static boolean isValidRechargeAmount(final int amount) {
        return amount > 0 && amount <= 10000;
    }
}


class User {
    private Long mobileNumber;
    private BigDecimal balance;
    private TariffPlan plan;

    public User(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(mobileNumber, user.mobileNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mobileNumber);
    }

    public TariffPlan getPlan() {
        return plan;
    }

    public void setPlan(TariffPlan plan) {
        this.plan = plan;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

enum TariffPlan {
    PLAN_25P,
    PLAN_50P,
    PLAN_1RS;
}

interface EasyRechargeController {
    void startEasyRechargeJourney();
}

class EasyRechargeCmdFrontController implements EasyRechargeController {
    private final Scanner scanner;
    private final EasyRecharge easyRecharge;

    // common constants can externalized
    private static final BigDecimal BALANCE_THRESHOLD = new BigDecimal("200");
    private static final String INVALID_INPUT = "Invalid input..!!";
    private static final String RECHARGE_SUCCESSFULLY = "Recharge successfully";

    public EasyRechargeCmdFrontController() {
        scanner =new Scanner(System.in);
        easyRecharge = new EasyRechargeImpl();
    }

    @Override
    public void startEasyRechargeJourney() {
        System.out.println("Welcome to Easy Recharge. Please enter your phone number to continue :: ");
        String input = scanner.nextLine();

        if (ValidationUtil.isValidMobileNumber(input)) {

            Long mobileNumber = Long.parseLong(input);
            if (easyRecharge.isUserExists(mobileNumber)) {
                successfulAuthenticationJourney(mobileNumber);

            } else {
                generateAndValidateOtp(mobileNumber);

            }
        } else {
            System.err.println("Invalid Mobile Number..!!!");
            startEasyRechargeJourney();

        }
    }

    private void successfulAuthenticationJourney(final Long mobileNumber) {
        System.out.println("What would you like to do?");
        System.out.println("Press 1 to Check Balance");
        System.out.println("Press 2 Recharge");
        int menuInput = scanner.nextInt();
        switch (menuInput) {
            case 1:
                BigDecimal balance = easyRecharge.getBalanceByMobileNumber(mobileNumber);
                System.out.println("Your balance is " + balance + " Rs.");

                rechargeConfirmationJourney(mobileNumber, balance);
                break;

            case 2:
                rechargeJourney(mobileNumber);
                break;

            default:
                System.err.println(INVALID_INPUT);
                successfulAuthenticationJourney(mobileNumber);
                break;
        }
    }

    private void rechargeConfirmationJourney(final Long mobileNumber, final BigDecimal balance) {


        if (balance.compareTo(BALANCE_THRESHOLD) < 1) {
            System.out.println("Would you like to recharge?");
            System.out.println("Yes to Proceed to recharge menu");
            System.out.println("No to exit");

            String subMenuInput = scanner.next();
            switch (subMenuInput.toUpperCase()) {
                case "YES":
                    rechargeJourney(mobileNumber);
                    break;

                case "NO":
                    System.exit(0);

                default:
                    System.err.println(INVALID_INPUT);
                    rechargeConfirmationJourney(mobileNumber, balance);
            }
        }
    }

    private void rechargeJourney(final Long mobileNumber) {
        System.out.println("We have following bundles you can use, choose one\n" +
                "                        1. 50p for 1 minute call. 400 Rs per month\n" +
                "                        2. 25p for 1 minute call. 600 Rs per month\n" +
                "                        3. 1Rs for 1 minute call. ");

        int menuInput = scanner.nextInt();
        switch (menuInput) {
            case 1:
                easyRecharge.updateTariffPlan(TariffPlan.PLAN_50P, mobileNumber);
                System.out.println(RECHARGE_SUCCESSFULLY);
                break;
            case 2:
                easyRecharge.updateTariffPlan(TariffPlan.PLAN_25P, mobileNumber);
                System.out.println(RECHARGE_SUCCESSFULLY);
                break;
            case 3:
                rechargeArbitraryJourney(mobileNumber);
                break;
            default:
                System.err.println(INVALID_INPUT);
                rechargeJourney(mobileNumber);
                break;
        }

    }

    private void rechargeArbitraryJourney(final Long mobileNumber) {
        System.out.println("Please enter amount to recharge :: ");
        int amount = scanner.nextInt();
        if (ValidationUtil.isValidRechargeAmount(amount)) {
            easyRecharge.updateTariffPlan(TariffPlan.PLAN_1RS, mobileNumber);
            easyRecharge.rechargeBalance(mobileNumber, amount);
            System.out.println(RECHARGE_SUCCESSFULLY);
        } else {
            System.err.println("You can not recharge with a specific amount. Please re-enter the amount.");
            rechargeArbitraryJourney(mobileNumber);
        }
    }

    private void generateAndValidateOtp(final Long mobileNumber) {
        easyRecharge.generateOTP(mobileNumber);
        validateOtp(mobileNumber);
    }

    private void validateOtp(final Long mobileNumber) {
        System.out.println("Please Enter your OTP sent to you :: ");
        String otpInput = "";
        if (scanner.hasNext()) {
            otpInput = scanner.next();
        }

        if (easyRecharge.validateOtp(mobileNumber, otpInput)) {
            easyRecharge.createNewUser(mobileNumber);
            successfulAuthenticationJourney(mobileNumber);

        } else {
            invalidOtpJourney(mobileNumber);

        }
    }

    private void invalidOtpJourney(final Long mobileNumber) {
        try {
            System.err.println("Your OTP is invalid! Press 1 to re-enter, Press 2 to re-generate");
            final int menuInput = scanner.nextInt();
            switch (menuInput) {
                case 1:
                    validateOtp(mobileNumber);
                    break;

                case 2:
                    generateAndValidateOtp(mobileNumber);
                    break;

                default:
                    System.err.println(INVALID_INPUT);
                    validateOtp(mobileNumber);
                    break;
            }

        } catch (InputMismatchException inputMismatchExp) {
            invalidOtpJourney(mobileNumber);
        }
    }
}

