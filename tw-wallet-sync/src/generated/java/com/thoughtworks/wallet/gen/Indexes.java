/*
 * This file is generated by jOOQ.
 */
package com.thoughtworks.wallet.gen;


import com.thoughtworks.wallet.gen.tables.FlywaySchemaHistory;
import com.thoughtworks.wallet.gen.tables.TblDcep;
import com.thoughtworks.wallet.gen.tables.TblIdentities;
import com.thoughtworks.wallet.gen.tables.TblTransactions;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index FLYWAY_SCHEMA_HISTORY_S_IDX = Indexes0.FLYWAY_SCHEMA_HISTORY_S_IDX;
    public static final Index TBL_BLOCKS_OWNER_INDEX = Indexes0.TBL_BLOCKS_OWNER_INDEX;
    public static final Index TBL_IDENTITIES_HASH_INDEX = Indexes0.TBL_IDENTITIES_HASH_INDEX;
    public static final Index TBL_TRANSACTIONS_HASH_INDEX = Indexes0.TBL_TRANSACTIONS_HASH_INDEX;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index FLYWAY_SCHEMA_HISTORY_S_IDX = Internal.createIndex("flyway_schema_history_s_idx", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS }, false);
        public static Index TBL_BLOCKS_OWNER_INDEX = Internal.createIndex("tbl_blocks_owner_index", TblDcep.TBL_DCEP, new OrderField[] { TblDcep.TBL_DCEP.OWNER }, false);
        public static Index TBL_IDENTITIES_HASH_INDEX = Internal.createIndex("tbl_identities_hash_index", TblIdentities.TBL_IDENTITIES, new OrderField[] { TblIdentities.TBL_IDENTITIES.HASH }, false);
        public static Index TBL_TRANSACTIONS_HASH_INDEX = Internal.createIndex("tbl_transactions_hash_index", TblTransactions.TBL_TRANSACTIONS, new OrderField[] { TblTransactions.TBL_TRANSACTIONS.HASH }, false);
    }
}
