package org.acme.timeout;

import java.time.temporal.ChronoUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

@Path("/timeout")
public class TimeoutTest {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(fallbackMethod = "timeout")
    //@Retry
    @Timeout(value = 5000, unit = ChronoUnit.MILLIS)
    public String hello() {
        MyEntity entity = MyEntity.findById((long)1);

        return entity.mystring;
        //return "Hello";
    }

    public String timeout() {
        return "fallback";
    }
}