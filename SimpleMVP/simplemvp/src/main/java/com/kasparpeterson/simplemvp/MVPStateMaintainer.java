package com.kasparpeterson.simplemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by kaspar on 01/09/16.
 */
class MVPStateMaintainer {

    private final String TAG = MVPStateMaintainer.class.getSimpleName();
    private final String stateMaintainerTag;
    private final WeakReference<FragmentManager> fragmentManager;
    private StateMaintainerFragment stateMaintainerFragment;

    MVPStateMaintainer(FragmentManager fragmentManager, String stateMaintainerTag) {
        this.fragmentManager = new WeakReference<>(fragmentManager);
        this.stateMaintainerTag = stateMaintainerTag;
    }

    /**
     * @return  true: fragment was created for the first time
     *          false: recovering the object
     */
    boolean firstTimeIn() {
        if (fragmentManager.get() != null) {
            stateMaintainerFragment = (StateMaintainerFragment)
                    fragmentManager.get().findFragmentByTag(stateMaintainerTag);

            if (stateMaintainerFragment == null) {
                Log.d(TAG, "Creating a new RetainedFragment: " + stateMaintainerTag);

                stateMaintainerFragment = new StateMaintainerFragment();
                fragmentManager.get()
                        .beginTransaction()
                        .add(stateMaintainerFragment, stateMaintainerTag)
                        .commit();
                return true;
            } else {
                Log.d(TAG, "Returning an existing retained fragment: " + stateMaintainerTag);
            }
        } else {
            Log.e(TAG, "Error in firstTimeIn(), FragmentManager reference is null!");
        }
        return false;
    }

    void put(String key, Object object) {
        stateMaintainerFragment.put(key, object);
    }

    void put(Object object) {
        stateMaintainerFragment.put(object);
    }

    <T> T get(String key) {
        return stateMaintainerFragment.get(key);
    }

    boolean hasKey(String key) {
        return stateMaintainerFragment.get(key) != null;
    }

    public static class StateMaintainerFragment extends Fragment {
        private HashMap<String, Object> data = new HashMap<>();

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
        }

        public void put(String key, Object object) {
            data.put(key, object);
        }

        public void put(Object object) {
            put(object.getClass().getName(), object);
        }

        @SuppressWarnings("unchecked")
        public <T> T get(String key) {
            return (T) data.get(key);
        }

    }

}
