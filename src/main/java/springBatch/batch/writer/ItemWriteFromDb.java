package springBatch.batch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import springBatch.entity.User;

import java.util.List;
 
/**
 * 写方法
 *
 * @Package: com.springbatch._09item_reader_from_db
 * @ClassName: ItemWriteFromDb
 * @author: zq
 * @since: 2020/6/21 21:47
 * @version: 1.0
 * @Copyright: 2020 zq. All rights reserved.
 */
@Component("itemWriteFromDb")
public class ItemWriteFromDb implements ItemWriter<User> {
 
    @Override
    public void write(List<? extends User> list) throws Exception {
 
        System.out.println("writing====================");
        for (User user : list) {
            System.out.println(user);
        }
 
 
    }
}