package com.app.collectiontool.repository;

import com.app.collectiontool.domain.Gadget;
import com.app.collectiontool.jooq.tables.records.GadgetRecord;
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

import static com.app.collectiontool.jooq.tables.Gadget.GADGET;

@Singleton
public class GadgetRepository {

  final DSLContext context;

  @Inject
  public GadgetRepository(DataSource ds) {
    this.context = DSL.using(new DefaultConfiguration().derive(ds));
  }

  public Promise<List<Gadget>> getAll() {
    SelectJoinStep all = context.select().from(GADGET);
    return Blocking.get(() -> all.fetchInto(Gadget.class));
  }

  public Promise<Gadget> getById(Long id) {
    SelectConditionStep where = context.select().from(GADGET).where(GADGET.ID.equal(id));
    return Blocking.get(() -> where.fetchOne().into(Gadget.class));
  }

  public Promise<Gadget> add(Gadget gadget) {
    GadgetRecord gadgetRecord = context.newRecord(GADGET, gadget);
    return Blocking.op(gadgetRecord::store)
      .next(Blocking.op(gadgetRecord::refresh))
      .map(() -> gadgetRecord.into(Gadget.class));
  }

  public Promise<Gadget> update(Map<String, Object> gadget) {
    GadgetRecord record = context.newRecord(GADGET, gadget);

    return Blocking.get(() -> context.executeUpdate(record))
      .blockingOp(count -> record.refresh())
      .map(i -> record.into(Gadget.class));
  }

  public Operation delete(Long id) {
    DeleteConditionStep<GadgetRecord> deleteWhereId = context.deleteFrom(GADGET).where(GADGET.ID.equal(id));
    return Blocking.op(deleteWhereId::execute);
  }

  public Operation deleteAll() {
    DeleteWhereStep<GadgetRecord> delete = context.deleteFrom(GADGET);
    return Blocking.op(delete::execute);
  }
}
