package com.phase1.InterfacesAndCollections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

  private static final Logger LOG = LogManager.getLogger(MapDemo.class);

  public static void main(String[] args) {

    HashMap<Integer, String> hm = new HashMap<Integer, String>();
    hm.put(1, "Tim");
    hm.put(2, "Mary");
    hm.put(3, "Catie");

    LOG.debug("\nThe elements of Hashmap are ");

    for (Map.Entry m : hm.entrySet()) {
      LOG.debug("{} {}", m.getKey(), m.getValue());
    }

    //HashTable
    Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
    ht.put(4, "Ales");
    ht.put(5, "Rosy");
    ht.put(6, "Jack");
    ht.put(7, "John");

    LOG.debug("\nThe elements of HashTable are ");

    for (Map.Entry n : ht.entrySet()) {
      LOG.debug("{} {}", n.getKey(), n.getValue());
    }

    //TreeMap
    TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    map.put(8, "Annie");
    map.put(9, "Carlotte");
    map.put(10, "Catie");

    LOG.debug("\nThe elements of TreeMap are ");

    for (Map.Entry l : map.entrySet()) {
      LOG.debug("{} {}", l.getKey(), l.getValue());
    }
  }
}
