/*
 * Copyright 2020 Emory University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.cs.sort.comparison;

import edu.emory.cs.sort.AbstractSort;

import java.util.Comparator;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSort<T> {
    public InsertionSort() {
        this(Comparator.naturalOrder());
    }

    public InsertionSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] array, int beginIndex, int endIndex) {
        sort(array, beginIndex, endIndex, 1);
    }

    protected void sort(T[] array, int beginIndex, int endIndex, final int h) {
        int begin_h = beginIndex + h;

        for (int i = begin_h; i < endIndex; i++)
            for (int j = i; begin_h <= j && compareTo(array, j, j - h) < 0; j -= h)
                swap(array, j, j - h);
    }
}
