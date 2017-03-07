package com.example.angel.maestrodetalle;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.satxa.maestrodetalle.dummy.DummyContent;

/**
 * A fragment representing a single Juego detail screen.
 * This fragment is either contained in a {@link JuegoListActivity}
 * in two-pane mode (on tablets) or a {@link JuegoDetailActivity}
 * on handsets.
 */
public class JuegoDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

//    private ImageView imageView;

    public JuegoDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name);
            }

//            new PhotoCollector().execute();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.juego_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.tvName)).setText(mItem.name);
            ((TextView) rootView.findViewById(R.id.tvYear)).setText(mItem.year);
            ((TextView) rootView.findViewById(R.id.tvDevelopers)).setText(mItem.developers);
            ((TextView) rootView.findViewById(R.id.tvPublishers)).setText(mItem.publishers);
            ((TextView) rootView.findViewById(R.id.tvPlatforms)).setText(mItem.platforms);
            ((TextView) rootView.findViewById(R.id.tvSynopsis)).setText(mItem.synopsis);
        }

        return rootView;
    }

    /*private class PhotoCollector extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... voids) {
            URL url = null;
            Bitmap bmp = null;
            try {
                url = new URL(mItem.urlLogo);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            imageView.setImageBitmap(bitmap);
        }
    }*/
}
