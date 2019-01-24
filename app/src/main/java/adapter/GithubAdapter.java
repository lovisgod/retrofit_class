package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ayo.retrofitgithub.R;

import java.util.List;

import model.GithubRepo;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {

    private List<GithubRepo> githubRepoList;

    private Context context;


    public GithubAdapter( Context context){

        this.context = context;

    }
    @NonNull
    @Override
    public GithubAdapter.GithubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user, viewGroup, false);
        return new GithubViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubAdapter.GithubViewHolder githubViewHolder, int position) {

        GithubRepo list = githubRepoList.get(position);
        githubViewHolder.repo.setText(list.getId());
        githubViewHolder.repo_description.setText(list.getName());

    }

    @Override
    public int getItemCount() {
        return githubRepoList.size();
    }

    public void setREsult(List<GithubRepo> list){

        githubRepoList = list;
        notifyDataSetChanged();
    }


    public class GithubViewHolder extends RecyclerView.ViewHolder {

        public TextView repo;
        public  TextView repo_description;

        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);

            repo = (TextView)itemView.findViewById(R.id.repo_id);
            repo_description = (TextView)itemView.findViewById(R.id.repo_description);

        }
    }
}