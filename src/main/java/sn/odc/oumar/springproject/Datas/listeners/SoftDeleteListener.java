package sn.odc.oumar.springproject.Datas.listeners;

import jakarta.persistence.PreRemove;
import sn.odc.oumar.springproject.Datas.listeners.impl.SoftDeletable;

public class SoftDeleteListener {
    @PreRemove
    public void preRemove(SoftDeletable softDeletable) {
        softDeletable.setDeleted(true);
    }
}
