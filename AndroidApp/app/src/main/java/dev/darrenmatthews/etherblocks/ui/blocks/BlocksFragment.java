package dev.darrenmatthews.etherblocks.ui.blocks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import dev.darrenmatthews.etherblocks.MainActivity;
import dev.darrenmatthews.etherblocks.R;

public class BlocksFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_blocks, container, false);

        root.findViewById(R.id.genesisButton).setOnClickListener(v -> {
            ((MainActivity)getActivity()).displayGenesisBlock();
            Button buttonGenesis = root.findViewById(R.id.genesisButton);
            disableButton(buttonGenesis);
            Button buttonLatest = root.findViewById(R.id.latestButton);
            enableButton(buttonLatest);
        });

        root.findViewById(R.id.latestButton).setOnClickListener(v -> {
            ((MainActivity)getActivity()).createLatestBlockSubscription();
            Button buttonLatest = root.findViewById(R.id.latestButton);
            disableButton(buttonLatest);
            Button buttonGenesis = root.findViewById(R.id.genesisButton);
            enableButton(buttonGenesis);
        });

        //Update the View with all the model data
        ((MainActivity)getActivity()).getBlocksViewModel().getNumber().observe(getViewLifecycleOwner(), num -> {
            if(num != null){
                ((TextView) root.findViewById(R.id.blockNumber)).setText(num.toString());
            }
        });

        ((MainActivity)getActivity()).getBlocksViewModel().getDifficulty().observe(getViewLifecycleOwner(), diff -> {
            if(diff != null){
                ((TextView) root.findViewById(R.id.blockDifficulty)).setText(diff.toString());
            }
        });

        ((MainActivity)getActivity()).getBlocksViewModel().getMiner().observe(getViewLifecycleOwner(), miner -> {
            if(miner != null){
                ((TextView) root.findViewById(R.id.blockMiner)).setText(miner);
            }
        });

        ((MainActivity)getActivity()).getBlocksViewModel().getNonce().observe(getViewLifecycleOwner(), nonce -> {
            if(nonce != null){
                ((TextView) root.findViewById(R.id.blockNonce)).setText(nonce.toString());
            }
        });

        ((MainActivity)getActivity()).getBlocksViewModel().getParent().observe(getViewLifecycleOwner(), parent -> {
            if(parent != null){
                ((TextView) root.findViewById(R.id.blockParent)).setText(parent);
            }
        });

        ((MainActivity)getActivity()).getBlocksViewModel().getTransactions().observe(getViewLifecycleOwner(), trans -> {
            if(trans != null){
                ((TextView) root.findViewById(R.id.blockTransactions)).setText(String.valueOf(trans.size()));
            }
        });

        ((MainActivity)getActivity()).getBlocksViewModel().getSize().observe(getViewLifecycleOwner(), size -> {
            if(size != null){
                ((TextView) root.findViewById(R.id.blockSize)).setText(size + " bytes");
            }
        });

        ((MainActivity)getActivity()).getBlocksViewModel().getTimestamp().observe(getViewLifecycleOwner(), time -> {
            if(time != null){
                long millis = time.longValue();
                Instant instant = Instant.ofEpochSecond(millis);
                Date date = Date.from(instant);

                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss a (dd-MM-yyyy)", Locale.getDefault());
                format.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateString = format.format(date);

                ((TextView) root.findViewById(R.id.blockTimestamp)).setText(dateString);
            }
        });

        ((MainActivity)getActivity()).getBlocksViewModel().getType().observe(getViewLifecycleOwner(), type -> {
            if(type != null){
                ((TextView) root.findViewById(R.id.blockTitleNumber)).setText(type);
            }
        });

        return root;
    }

    private void enableButton(Button button) {
        button.setVisibility(View.VISIBLE);
        button.setClickable(true);
    }

    private void disableButton(Button button){
        button.setClickable(false);
        button.setVisibility(View.INVISIBLE);
    }
}