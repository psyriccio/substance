/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pushingpixels.substance.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 *
 * @author psyriccio
 */
public class SubstanceOptions {

    private static final Map<String, Class> transitionAnimExcludes = new ConcurrentHashMap<>();

    public static Map<String, Class> getTransitionAnimExcludes() {
        return transitionAnimExcludes;
    }

    public static boolean isTransitionAnimOn(Class clazz) {
        //System.out.println("chk " + clazz.getCanonicalName());
        if(transitionAnimExcludes.containsValue(clazz)) {
            return false;
        } else {
            if (!transitionAnimExcludes.keySet().stream()
                    .noneMatch((key) -> (clazz.getCanonicalName().startsWith(key)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTransitionAnimOn(String canonicalName) {
        if(transitionAnimExcludes.containsKey(canonicalName)) {
            return false;
        } else {
            if (!transitionAnimExcludes.keySet().stream()
                    .noneMatch((key) -> (canonicalName.startsWith(key)))) {
                return false;
            }
        }
        return true;
    }

    public static void addToTransitionAnimExcludes(Class clazz) {
        //System.out.println("add " + clazz.getCanonicalName());
        transitionAnimExcludes.put(clazz.getCanonicalName(), clazz);
    }

    public static void delFromTransitionAnimExcludes(Class clazz) {
        transitionAnimExcludes.remove(clazz.getCanonicalName());
    }

    public static void delFromTransitionAnimExcludes(String canonicalName) {
        transitionAnimExcludes.remove(canonicalName);
    }


}
