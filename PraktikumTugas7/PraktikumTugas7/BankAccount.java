/* 
'########:::::'###::::'##::: ##:'########::'##:::'##:'########:'####:'##:::'##:'########::'####::::'###::::'########::'####:'########::::'###::::'##::: ##:'########::'####:
 ##.... ##:::'## ##::: ###:: ##: ##.... ##:. ##:'##::..... ##::. ##:: ##::'##:: ##.... ##:. ##::::'## ##::: ##.... ##:. ##:: ##.....::::'## ##::: ###:: ##: ##.... ##:. ##::
 ##:::: ##::'##:. ##:: ####: ##: ##:::: ##::. ####::::::: ##:::: ##:: ##:'##::: ##:::: ##:: ##:::'##:. ##:: ##:::: ##:: ##:: ##::::::::'##:. ##:: ####: ##: ##:::: ##:: ##::
 ##:::: ##:'##:::. ##: ## ## ##: ##:::: ##:::. ##::::::: ##::::: ##:: #####:::: ########::: ##::'##:::. ##: ########::: ##:: ######:::'##:::. ##: ## ## ##: ##:::: ##:: ##::
 ##:::: ##: #########: ##. ####: ##:::: ##:::: ##:::::: ##:::::: ##:: ##. ##::: ##.. ##:::: ##:: #########: ##.. ##:::: ##:: ##...:::: #########: ##. ####: ##:::: ##:: ##::
 ##:::: ##: ##.... ##: ##:. ###: ##:::: ##:::: ##::::: ##::::::: ##:: ##:. ##:: ##::. ##::: ##:: ##.... ##: ##::. ##::: ##:: ##::::::: ##.... ##: ##:. ###: ##:::: ##:: ##::
 ########:: ##:::: ##: ##::. ##: ########::::: ##:::: ########:'####: ##::. ##: ##:::. ##:'####: ##:::: ##: ##:::. ##:'####: ##::::::: ##:::: ##: ##::. ##: ########::'####:
........:::..:::::..::..::::..::........::::::..:::::........::....::..::::..::..:::::..::....::..:::::..::..:::::..::....::..::::::::..:::::..::..::::..::........:::....::
 :'#######::'##::::::::'########::::'##:::'########:::'#####:::'########:::'#####:::'########::::'##::::::'##::::::'##:::::'#####::::'#######::'########::::::::::::::::::::
'##.... ##: ##:::'##:: ##.....:::'####::: ##.....:::'##.. ##:: ##..  ##::'##.. ##:: ##..  ##::'####::::'####::::'####::::'##.. ##::'##.... ##: ##.....::::::::::::::::::::::
..::::: ##: ##::: ##:: ##::::::::.. ##::: ##:::::::'##:::: ##:..:: ##:::'##:::: ##:..:: ##::::.. ##::::.. ##::::.. ##:::'##:::: ##:..::::: ##: ##:::::::::::::::::::::::::::
:'#######:: ##::: ##:: #######::::: ##::: #######:: ##:::: ##:::: ##:::: ##:::: ##:::: ##::::::: ##:::::: ##:::::: ##::: ##:::: ##::'#######:: #######::::::::::::::::::::::
'##:::::::: #########:...... ##:::: ##:::...... ##: ##:::: ##::: ##::::: ##:::: ##::: ##:::::::: ##:::::: ##:::::: ##::: ##:::: ##::...... ##:...... ##:::::::::::::::::::::
 ##::::::::...... ##::'##::: ##:::: ##:::'##::: ##:. ##:: ##:::: ##:::::. ##:: ##:::: ##:::::::: ##:::::: ##:::::: ##:::. ##:: ##::'##:::: ##:'##::: ##:::::::::::::::::::::
 #########::::::: ##::. ######:::'######:. ######:::. #####::::: ##::::::. #####::::: ##::::::'######::'######::'######::. #####:::. #######::. ######::::::::::::::::::::::
.........::::::::..::::......::::......:::......:::::.....::::::..::::::::.....::::::..:::::::......:::......:::......::::.....:::::.......::::......:::::::::::::::::::::::
'########:'####:::::::::::'######:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
... ##..::. ##:::::::::::'##... ##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::: ##::::: ##::::::::::: ##:::..:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::: ##::::: ##::'#######: ##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::: ##::::: ##::........: ##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::: ##::::: ##::::::::::: ##::: ##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::: ##::::'####::::::::::. ######:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
:::..:::::....::::::::::::......::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
*/

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private String password;
    private String accountType;
    private String bankName;
    private double balance;

    // konstruktor untuk inisialisasi objek BankAccount
    public BankAccount(String accountHolder, String accountNumber, String password, String accountType, String bankName, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.password = password;
        this.accountType = accountType;
        this.bankName = bankName;
        this.balance = initialBalance;
    }

    // Method login yang melempar exception
    // 1. Cari akun berdasarkan nomor rekening
    // 2. Kalau akun tidak ditemukan, langsung lempar exception
    // 3. Validasi password
    // 4. Login berhasil
    public static BankAccount login(BankAccount[] accounts, String accNumber, String password)
            throws AccountNotFoundException, WrongPasswordException {

        BankAccount foundAccount = null;

        // jika nomor rekening dan password valid maka akan keluar dari loop
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNumber)) {
                foundAccount = acc;
                break;
            }
        }

        // menggunakan null karena accounts adalah array of object
        // jika akun tidak ditemukan, lempar exception
        // jika akun ditemukan, validasi password
        if (foundAccount == null) {
            throw new AccountNotFoundException("Yang bener napa masukin Nomor rekening.");
            
        }

        // jika password salah, lempar exception
        if (!foundAccount.getPassword().equals(password)) {
            throw new WrongPasswordException("Hayoo lo password elo salah, duit lu akan di klaim bank sekarang >.<");
        }

        // jika akun ditemukan dan password benar, kembalikan objek akun
        return foundAccount;
    }

    // Method untuk melakukan penarikan
    // 1. Validasi jumlah penarikan
    // 2. Jika jumlah penarikan lebih besar dari saldo, lempar exception
    // 3. Jika saldo kurang dari 0, lempar exception
    // 4. Jika jumlah penarikan valid, kurangi saldo
    // 5. Tampilkan saldo tersisa
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("pasti liat video tiktok aneh-aneh, coba lagi wak.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Duit lo gak cukup wak.");
        }

        balance -= amount;
        System.out.println("Dengan bangga kami menyatakan saldo anda tersisa : Rp." + balance);
    }

    // Getter methods
    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getBankName() {
        return bankName;
    }
}
