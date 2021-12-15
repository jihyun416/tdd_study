package chap07P;

public interface UserRepository {
    void save(User user);
    User findById(String id);
}
