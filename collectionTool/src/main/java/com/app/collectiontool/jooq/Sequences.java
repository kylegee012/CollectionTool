/**
 * This class is generated by jOOQ
 */
package jooq;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in PUBLIC
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_7C7DC8B5_15AA_4DCC_802C_6AF18C7634AC</code>
     */
    public static final Sequence<Long> SYSTEM_SEQUENCE_7C7DC8B5_15AA_4DCC_802C_6AF18C7634AC = new SequenceImpl<Long>("SYSTEM_SEQUENCE_7C7DC8B5_15AA_4DCC_802C_6AF18C7634AC", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);

    /**
     * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_98E5EF30_D011_4760_9FD2_49A44B2269B9</code>
     */
    public static final Sequence<Long> SYSTEM_SEQUENCE_98E5EF30_D011_4760_9FD2_49A44B2269B9 = new SequenceImpl<Long>("SYSTEM_SEQUENCE_98E5EF30_D011_4760_9FD2_49A44B2269B9", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
