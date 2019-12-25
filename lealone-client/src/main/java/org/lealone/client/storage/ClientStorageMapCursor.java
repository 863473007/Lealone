/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lealone.client.storage;

import java.util.Iterator;
import java.util.Map.Entry;

import org.lealone.storage.StorageMapCursor;

public class ClientStorageMapCursor<K, V> implements StorageMapCursor<K, V> {

    private final Iterator<Entry<K, V>> iterator;
    private Entry<K, V> e;

    public ClientStorageMapCursor(Iterator<Entry<K, V>> iterator) {
        this.iterator = iterator;
    }

    @Override
    public K getKey() {
        return e.getKey();
    }

    @Override
    public V getValue() {
        return e.getValue();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public K next() {
        e = iterator.next();
        return e.getKey();
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}
