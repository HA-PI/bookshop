package xyz.bookshop.dao;

import xyz.bookshop.entity.Book;
import xyz.bookshop.entity.BuyRecord;
import xyz.bookshop.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2017/6/18.
 */
public class BuyRecordDao extends BaseDao{
    public boolean exists(String recordid) {
        try {
            ResultSet rs = this.select("select * from buyrecord where id=? ", recordid);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public BuyRecord find(String username) {
        try {
            ResultSet rs = this.select("select * from buyrecord where username=? ordered by buytime desc",username);
            if (rs.next()) {
                return new BuyRecord(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getBinaryStream(10),
                        rs.getString(11)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(BuyRecord buyRecord) {
        return this.modify("insert into buyrecord values(null,?,?,now(),?,?,?,?,?,?,?)",
                buyRecord.getUsername(),buyRecord.getBuynumber(),buyRecord.getBookid(),
                buyRecord.getBookname(),buyRecord.getAuthor(),buyRecord.getPrice(),
                buyRecord.getPress(),buyRecord.getImg(),buyRecord.getImgtype());
    }


}
