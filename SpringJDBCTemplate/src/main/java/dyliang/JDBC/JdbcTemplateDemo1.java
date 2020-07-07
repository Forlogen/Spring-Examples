package dyliang.JDBC;

import dyliang.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/sql_store?serverTimezone=GMT");
        ds.setUsername("root");
        ds.setPassword("120809");

        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);

        // 查询所有
        List<Account> accounts = jt.query("select * from account where money = ?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
        for(Account account : accounts){
            System.out.println(account);
        }

//        // 保存
//        jt.update("insert into account(name,money)values(?,?)","Ball",1000f);
//
//        // 更新
//        jt.update("update account set name=?,money=? where id=?","Amy", 2000, 1);
//
//        // 删除
//        jt.update("delete from account where id=?",1);
//
//        // 查询一个
//        List<Account> accounts1 = jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(accounts.isEmpty()?"没有内容":accounts1.get(0));
//
//        //查询返回一行一列（使用聚合函数，但不加group by子句）
//        Long count = jt.queryForObject("select count(*) from account where money = ?",Long.class,1000f);
//        System.out.println(count);
    }
}
