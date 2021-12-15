package chap07P;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository repository;
    private EmailNotifier emailNotifier;
    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository repository, EmailNotifier emailNotifier) {
        this.passwordChecker = passwordChecker;
        this.repository = repository;
        this.emailNotifier = emailNotifier;
    }

    public void register(String id, String pw, String email) {
        if(passwordChecker.checkPasswordWeak(pw))
            throw new WeakPasswordException();
        if(repository.findById(id)!=null)
            throw new DupIdException();
        repository.save(new User(id, pw, email));
        emailNotifier.sendRegisterEmail(email);
    }
}
