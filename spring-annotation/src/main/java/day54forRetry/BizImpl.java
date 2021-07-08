package day54forRetry;

import com.alibaba.fastjson.JSONObject;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Service;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

@Service
@EnableRetry
public class BizImpl {

    @Retryable(value = ThriftException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    public  void get(){
        try {
            System.out.println("-------");
            throw new ThriftException("我超时了");
        }catch (Exception e){
            System.out.println("end");
            throw new ThriftException("uploadContract接口超时 request");
        }
    }
}
