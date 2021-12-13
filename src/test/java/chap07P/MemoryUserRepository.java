package chap07P;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {
    Map<String, User> userMap = new HashMap<>();

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return userMap.get(id);
    }
}
