package jdk8;

import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.concurrent.TimeUnit.DAYS;
import static org.apache.commons.lang3.StringUtils.appendIfMissing;

/**
 * Created by wdmyong on 2017/11/7.
 */
public enum Threshold {

    TEST("test", () -> "", () -> DAYS.toMillis(1), () -> 3);

    private final Supplier<String> prefix;
    private final LongSupplier expire;
    private final IntSupplier limit;

    Threshold(String constPrefix, Supplier<String> prefix, LongSupplier expireInMs,
              IntSupplier limit) {
        checkNotNull(constPrefix);
        checkNotNull(limit);
        checkNotNull(expireInMs);
        checkNotNull(prefix);
        this.prefix = () -> constPrefix + appendIfMissing(prefix.get(), ".");
        this.limit = limit;
        this.expire = expireInMs;
    }

    public String getPrefix() {
        return prefix.get();
    }

    public long getExpireInMs() {
        return expire.getAsLong();
    }

    public int getLimit() {
        return limit.getAsInt();
    }
}
