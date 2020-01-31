package com.app.collectiontool.repository;

import com.app.collectiontool.domain.Bucket;
import com.app.collectiontool.jooq.tables.records.BucketRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import ratpack.exec.Blocking;
import ratpack.exec.Operation;
import ratpack.exec.Promise;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import jooq.tables.records.BucketRecord;

import static jooq.Tables.BUCKET;

@Singleton
public class BucketRepository {

  final DSLContext context;

  @Inject
  public BucketRepository(DataSource ds) {
    this.context = DSL.using(new DefaultConfiguration().derive(ds));
  }

  public Promise<List<Bucket>> getAll() {
    SelectJoinStep all = context.select().from(BUCKET);
    return Blocking.get(() -> all.fetchInto(Bucket.class));
  }

  public Promise<Bucket> getById(Long id) {
    SelectConditionStep where = context.select().from(BUCKET).where(BUCKET.bucektId.equal(id));
    return Blocking.get(() -> where.fetchOne().into(Bucket.class));
  }

  public Promise<Bucket> add(Bucket bucket) {
    jooq.tables.records.BucketRecord bucketRecord = context.newRecord(BUCKET, bucket);
    return Blocking.op(bucketRecord::store)
      .next(Blocking.op(bucketRecord::refresh))
      .map(() -> bucketRecord.into(Bucket.class));
  }

  public Promise<Bucket> addGadget(Map<String, Object> bucket) {
    BucketRecord record = context.newRecord(BUCKET, bucket);

    return Blocking.get(() -> context.executeUpdate(record))
            .blockingOp(count -> record.refresh())
            .map(i -> record.into(Bucket.class));
  }

  public Promise<Bucket> update(Map<String, Object> bucket) {
    BucketRecord record = context.newRecord(BUCKET, bucket);

    return Blocking.get(() -> context.executeUpdate(record))
      .blockingOp(count -> record.refresh())
      .map(i -> record.into(Bucket.class));
  }

  public Operation delete(Long id) {
    DeleteConditionStep<BucketRecord> deleteWhereId = context.deleteFrom(BUCKET).where(BUCKET.ID.equal(id));
    return Blocking.op(deleteWhereId::execute);
  }

  public Operation deleteAll() {
    DeleteWhereStep<BucketRecord> delete = context.deleteFrom(BUCKET);
    return Blocking.op(delete::execute);
  }
}
