package sn.odc.oumar.springproject.Web.Dtos.Response.impl;

import java.util.List;

public interface Imprimable<T> {
    void exportToExcel(List<T> data, String fileName);
}