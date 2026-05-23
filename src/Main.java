import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new AdminUser("Ogbu Cyprian", "cysofthome@gmail.com"));

        users.add(new CustomerUser("Victor John",
                "victorjohn22@yahoo.com"));

        users.add(new LoanOfficerUser("Hosea Habila",
                "hoseahabi24@gmail.com"));

        System.out.println("=== USERS ===");

        for (User user: users){
            user.displayUserInfo();
        }

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction( "TRX001",
                5000,
                "APPROVED"));
        transactions.add(new Transaction("TRX002",
                1200,
                "PENDING"));
        transactions.add(new Transaction("TRX003",
                8500,
                "APPROVED"));

        System.out.println("\n=== TRANSACTIONS ===");
        for (Transaction transaction: transactions){
            transaction.displayTransactionInfo();
        }
        List<Transaction> approvedTransactions =
                transactions.stream()
                        .filter(transaction ->
                                transaction.getStatus()
                                        .equals("APPROVED"))
                        .collect(Collectors.toList());




        System.out.println(
                "\n=== APPROVED TRANSACTIONS ==="
        );

        approvedTransactions.forEach(transaction -> transaction.displayTransactionInfo());

        double totalApprovedAmount = approvedTransactions.stream().map(Transaction::getAmount).reduce(0.0, Double::sum);



        System.out.println(
                "\nTotal Approved Amount: " +
                        totalApprovedAmount
        );

        System.out.println("===SORTED TRANSACTION===");


        List<Transaction> sortedTransaction = transactions.stream().sorted(
                Comparator.comparing(Transaction::getAmount)
        ).toList();

        sortedTransaction.forEach(Transaction::displayTransactionInfo);
        System.out.println("===END OF SORTED TRANSACTION");

        System.out.println("=== GROUPED TRANSACTION ====");


        Map<String, List<Transaction>> groupedTransaction = transactions.stream().collect(Collectors.groupingBy(Transaction::getStatus));

        for(Map.Entry<String, List<Transaction>> entry:groupedTransaction.entrySet()){
            System.out.println("\n Status: " + entry.getKey());

            for (Transaction transaction:entry.getValue()){
                transaction.displayTransactionInfo();
            }
        }

        long approvedCount = transactions.stream().filter(
                transaction -> transaction.getStatus().equals("APPROVED")
        ).count();
        System.out.println("-------------------------");
        System.out.println(
                "\nApproved Transactions Count: "
                        + approvedCount
        );

        Optional<Transaction> transaction = transactions.stream().filter(t -> t.getAmount() > 5000).findFirst();
        transaction.ifPresent(Transaction::displayTransactionInfo);

       boolean hasLargeTransaction = transactions.stream().anyMatch(transaction1 -> transaction1.getAmount() > 7000);
        System.out.println("Has Large Transaction: "+ hasLargeTransaction);

        boolean allApproved = transactions.stream().allMatch(
                transaction2 -> transaction2.getStatus().equals("APPROVED")
        );

        System.out.println("ALL APROVED: " + allApproved);

        boolean noFailedTransaction = transactions.stream().noneMatch(
                transaction3 -> transaction3.getStatus().equals("FAILED")
        );
        System.out.println("No Failed Transaction: " + noFailedTransaction);

        transactions.stream()
                .peek(
                        transaction4 ->
                                System.out.println(
                                        "Before Filter: "
                                                + transaction4.getReference()
                                )
                )
                .filter(
                        transaction4 ->
                                transaction4.getAmount() > 3000
                )
                .toList();
List<Transaction> firstBatch = Arrays.asList(
        new Transaction("TRX001", 5000, "APPROVED"),
        new Transaction("TRX002", 1200, "PENDING")

);
List<Transaction> secondBatch = Arrays.asList(
        new Transaction("TRX003", 8500, "APPROVED" ),
        new Transaction("TRX004", 3000, "FAILED")
);

List<List<Transaction>> transactionGroups = Arrays.asList(firstBatch, secondBatch);

List<Transaction> allTransactions = transactionGroups.stream().flatMap(List::stream).toList();

        System.out.println("\n=== FLATTENED TRANSACTIONS ===");

        allTransactions.forEach(
                Transaction::displayTransactionInfo
        );
    }
}