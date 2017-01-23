/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**This class creates and updates hashmap
 *
 * @author aman dhiman
 */
public class SearchHashMap {
    private List<List<Integer>> indexList = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> getIndexList (){
        return indexList;
    }
    
    /**Initializes the hashmap with the given reference arraylist
     * 
     * @param ref reference arraylist
     * @return 
     */
    public HashMap<String, List<Integer>> createMap (ArrayList<Reference> ref){
        HashMap<String, List<Integer>> tempMap = new HashMap<String, List<Integer>>();
        String [] keys;
        String key;
        String title;
        String [] keywords;
        
        for (Reference temp : ref){
            title = temp.getTitle();
            keys = title.split(" ");
            for (int i = 0; i < keys.length; i++){
                key = keys[i].toLowerCase();
                if (!tempMap.containsKey(key)){
                    List<Integer> index = new ArrayList<Integer>();
                    for (Reference cur : ref){
                        keywords = cur.getTitle().split(" ");
                        for (int j = 0; j < keywords.length; j++){
                            if (keywords[j].equalsIgnoreCase(key)){
                            index.add(ref.indexOf(cur));
                            break;
                            }
                        }
                    }
                    indexList.add(index);
                    tempMap.put(key, index);
                }
            }
        }
        return tempMap;
    }
    
    /**Updates map after each successful addition to the reference arraylist
     * 
     * @param map the HashMap
     * @param ref reference arraylist
     */
    public void updateMap (HashMap map, ArrayList<Reference> ref){
        String [] keys;
        String key;
        String title;
        
        title = ref.get(ref.size()-1).getTitle();
        keys = title.split(" ");
        for (int i = 0; i < keys.length; i++){
            key = keys[i].toLowerCase();
            if (map.containsKey(key)){
                List<Integer> index = (ArrayList<Integer>)map.get(key);
                indexList.remove(index);
                index.add(ref.size()-1);
                indexList.add(index);
                map.put(key, index);
            }
            else {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(ref.size()-1);
                map.put(key, temp);
            }
        }

    }
}
