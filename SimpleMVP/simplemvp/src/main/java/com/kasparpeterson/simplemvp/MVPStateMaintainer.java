package com.kasparpeterson.simplemvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by kaspar on 01/09/16.
 */
class MVPStateMaintainer {

    private final String TAG;
    private final WeakReference<FragmentManager> fragmentManager;
    private StateMaintainerFragment stateMaintainerFragment;

    MVPStateMaintainer(FragmentManager fragmentManager, String stateMaintainerTag) {
        this.fragmentManager = new WeakReference<>(fragmentManager);
        this.TAG = stateMaintainerTag;
    }

    boolean isStateMaintainerCreated() {
        if (fragmentManager.get() != null) {
            stateMaintainerFragment = findFragment();
            return stateMaintainerFragment != null;
        }
        return false;
    }

    void initialiseStateMaintainer() {
        stateMaintainerFragment = findFragment();
        if (stateMaintainerFragment == null) {
            stateMaintainerFragment = new StateMaintainerFragment();
            save(fragmentManager.get());
        }
    }

    void put(String key, Object object) {
        stateMaintainerFragment.put(key, object);
    }

    <T> T get(String key) {
        return stateMaintainerFragment.get(key);
    }

    private StateMaintainerFragment findFragment() {
        return (StateMaintainerFragment) fragmentManager.get().findFragmentByTag(TAG);
    }

    private void save(@NonNull FragmentManager fragmentManager) {
        fragmentManager.beginTransaction()
                .add(stateMaintainerFragment, TAG)
                .commit();
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

        @SuppressWarnings("unchecked")
        public <T> T get(String key) {
            return (T) data.get(key);
        }

    }

}
