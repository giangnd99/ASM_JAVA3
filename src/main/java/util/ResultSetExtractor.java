/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Computer
 */
public interface ResultSetExtractor<T> {
    void extractData(ResultSet rs)throws SQLException;
}
