/**
 * This class is generated by jOOQ
 */
package jooq;


import javax.annotation.Generated;

import jooq.tables.Bucket;
import jooq.tables.Gadget;
import jooq.tables.records.BucketRecord;
import jooq.tables.records.GadgetRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>PUBLIC</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<GadgetRecord, Long> IDENTITY_GADGET = Identities0.IDENTITY_GADGET;
    public static final Identity<BucketRecord, Long> IDENTITY_BUCKET = Identities0.IDENTITY_BUCKET;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<GadgetRecord> CONSTRAINT_7 = UniqueKeys0.CONSTRAINT_7;
    public static final UniqueKey<BucketRecord> CONSTRAINT_75 = UniqueKeys0.CONSTRAINT_75;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BucketRecord, GadgetRecord> CONSTRAINT_756 = ForeignKeys0.CONSTRAINT_756;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<GadgetRecord, Long> IDENTITY_GADGET = createIdentity(Gadget.GADGET, Gadget.GADGET.GADGETID);
        public static Identity<BucketRecord, Long> IDENTITY_BUCKET = createIdentity(Bucket.BUCKET, Bucket.BUCKET.BUCKETID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<GadgetRecord> CONSTRAINT_7 = createUniqueKey(Gadget.GADGET, "CONSTRAINT_7", Gadget.GADGET.GADGETID);
        public static final UniqueKey<BucketRecord> CONSTRAINT_75 = createUniqueKey(Bucket.BUCKET, "CONSTRAINT_75", Bucket.BUCKET.BUCKETID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<BucketRecord, GadgetRecord> CONSTRAINT_756 = createForeignKey(jooq.Keys.CONSTRAINT_7, Bucket.BUCKET, "CONSTRAINT_756", Bucket.BUCKET.GADGETID);
    }
}
