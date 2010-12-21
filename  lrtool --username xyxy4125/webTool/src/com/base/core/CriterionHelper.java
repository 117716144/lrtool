package com.base.core;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CriterionHelper {

    private List<Criterion> criterions = new ArrayList<Criterion>();

    public void addCriterion(Criterion criterion) {
        if (criterion != null) criterions.add(criterion);
    }

    public Criterion buildCriterion() {
        if (criterions.isEmpty()) return null;

        if (criterions.size() == 1) return criterions.get(0);
        Iterator<Criterion> iterator = criterions.iterator();
        Criterion criterion = iterator.next();
        while (iterator.hasNext()) {
            criterion = Restrictions.and(criterion, iterator.next());
        }
        return criterion;
    }
}
