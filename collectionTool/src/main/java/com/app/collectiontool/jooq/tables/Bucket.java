/**
 * This class is generated by jOOQ
 */
package jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooq.Keys;
import jooq.Public;
import jooq.tables.records.BucketRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bucket extends TableImpl<BucketRecord> {

    private static final long serialVersionUID = 68746140;

    /**
     * The reference instance of <code>PUBLIC.BUCKET</code>
     */
    public static final Bucket BUCKET = new Bucket();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BucketRecord> getRecordType() {
        return BucketRecord.class;
    }

    /**
     * The column <code>PUBLIC.BUCKET.BUCKETID</code>.
     */
    public final TableField<BucketRecord, Long> BUCKETID = createField("BUCKETID", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("(NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_98E5EF30_D011_4760_9FD2_49A44B2269B9)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>PUBLIC.BUCKET.BUCKETNAME</code>.
     */
    public final TableField<BucketRecord, String> BUCKETNAME = createField("BUCKETNAME", org.jooq.impl.SQLDataType.VARCHAR.length(256), this, "");

    /**
     * The column <code>PUBLIC.BUCKET.GADGETID</code>.
     */
    public final TableField<BucketRecord, Long> GADGETID = createField("GADGETID", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>PUBLIC.BUCKET</code> table reference
     */
    public Bucket() {
        this("BUCKET", null);
    }

    /**
     * Create an aliased <code>PUBLIC.BUCKET</code> table reference
     */
    public Bucket(String alias) {
        this(alias, BUCKET);
    }

    private Bucket(String alias, Table<BucketRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bucket(String alias, Table<BucketRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<BucketRecord, Long> getIdentity() {
        return Keys.IDENTITY_BUCKET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BucketRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_75;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BucketRecord>> getKeys() {
        return Arrays.<UniqueKey<BucketRecord>>asList(Keys.CONSTRAINT_75);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<BucketRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BucketRecord, ?>>asList(Keys.CONSTRAINT_756);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bucket as(String alias) {
        return new Bucket(alias, this);
    }

    /**
     * Rename this table
     */
    public Bucket rename(String name) {
        return new Bucket(name, null);
    }
}
