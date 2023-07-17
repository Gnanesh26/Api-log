package testing.apilogdata.Service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class PricingPlan {
    @Value("rate.limit.client.basic")
    private String basic;


    @Value("rate.limit.client.free")
    private String free;

    public Bucket getPlanServiceBucket(String clientToken){
        return Bucket4j.builder().addLimit(getclientBnadwidth(clientToken)).build();

    }

    private Bandwidth getclientBnadwidth(String clientToken) {

        if(clientToken.equals("basic123"))
            return Bandwidth.classic(5, Refill.of(5, Duration.ofMinutes(1)));
        else if (clientToken.equals("free123"))
            return Bandwidth.classic(10, Refill.of(10, Duration.ofMinutes(1)));

            return  Bandwidth.classic(2,Refill.of(2,Duration.ofMinutes(1)));

        }

    }



