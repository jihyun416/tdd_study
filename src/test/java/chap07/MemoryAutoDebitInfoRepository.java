package chap07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository {
    Map<String, AutoDebitInfo> infos = new HashMap<>();

    @Override
    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }

    @Override
    public void save(AutoDebitInfo autoDebitInfo) {
        infos.put(autoDebitInfo.getUserId(), autoDebitInfo);
    }
}
