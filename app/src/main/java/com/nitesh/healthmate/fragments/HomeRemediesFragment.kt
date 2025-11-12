package com.nitesh.healthmate.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.faishion.vaama.orders.adapter.HomeListRemediesListAdapter
import com.faishion.vaama.orders.adapter.HomeListRemediesListAdapter.HomeRemediesClickListner
import com.faishion.vaama.orders.adapter.HospitalListAdapter
import com.nitesh.healthmate.R
import com.nitesh.healthmate.activities.LandingActivity
import com.nitesh.healthmate.databinding.FragmentHomeRemediesBinding
import com.nitesh.healthmate.model.HomeRemedy

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeRemediesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeRemediesFragment : Fragment(), HomeRemediesClickListner {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHomeRemediesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeRemediesBinding.inflate(layoutInflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as LandingActivity).title = "Home remedies"
        val homeRemediesList = arrayListOf(
            HomeRemedy(
                remediesId = "12345",
                title = "Cold & Cough Relief",
                category = "Immunity",
                categoryColor = "#4CAF50",
                shortDescription = "Natural ways to soothe sore throat and clear nasal congestion.",
                description = """
            <h3>Home Remedies for Cold & Cough</h3>
            <p>These simple remedies help relieve sore throat, reduce congestion, and boost recovery.</p>
            <ul>
                <li><b>Ginger Tea:</b> Boil water with crushed ginger, add honey and drink twice daily.</li>
                <li><b>Steam Inhalation:</b> Inhale steam from hot water with a pinch of turmeric or eucalyptus oil.</li>
                <li><b>Honey & Lemon:</b> Mix 1 tsp honey with ½ lemon juice in warm water; drink in morning.</li>
            </ul>
            <p><i>Tip:</i> Avoid cold drinks and rest well for faster relief.</p>
        """
            ),
            HomeRemedy(
                remediesId = "12346",
                title = "Indigestion Relief",
                category = "Digestive",
                categoryColor = "#FFC107",
                shortDescription = "Simple home tips to ease bloating, gas, and acidity.",
                description = """
            <h3>Natural Remedies for Indigestion</h3>
            <p>These help calm your stomach, improve digestion, and reduce bloating.</p>
            <ul>
                <li><b>Jeera Water:</b> Boil 1 tsp cumin seeds in water, cool and sip after meals.</li>
                <li><b>Ginger Juice:</b> Mix 1 tsp ginger juice with lemon and honey; consume before food.</li>
                <li><b>Fennel Seeds:</b> Chew 1 tsp fennel seeds after meals to ease digestion.</li>
            </ul>
            <p><i>Tip:</i> Avoid spicy and oily food until symptoms ease.</p>
        """
            ),
            HomeRemedy(
                remediesId = "12347",
                title = "Headache Relief",
                category = "Pain Relief",
                categoryColor = "#FF7043",
                shortDescription = "Easy natural ways to reduce tension and sinus headaches.",
                description = """
            <h3>Remedies for Headache</h3>
            <p>Use these natural ways to reduce stress and relax muscles.</p>
            <ul>
                <li><b>Peppermint Oil:</b> Apply diluted oil on temples for cooling relief.</li>
                <li><b>Ginger Tea:</b> Ginger’s anti-inflammatory properties help relieve tension.</li>
                <li><b>Hydration:</b> Drink plenty of water; dehydration often triggers headaches.</li>
            </ul>
            <p><i>Tip:</i> Rest in a quiet dark room and avoid screen time during headaches.</p>
        """
            ),
            HomeRemedy(
                remediesId = "12348",
                title = "Acne Treatment",
                category = "Skin Care",
                categoryColor = "#E91E63",
                shortDescription = "Home remedies to reduce pimples and promote clear skin.",
                description = """
            <h3>Natural Remedies for Acne</h3>
            <p>Try these gentle home solutions to reduce acne and improve skin clarity.</p>
            <ul>
                <li><b>Aloe Vera Gel:</b> Apply fresh aloe gel on the affected area twice daily.</li>
                <li><b>Turmeric Paste:</b> Mix turmeric with honey; apply for 10 minutes and rinse.</li>
                <li><b>Green Tea Rinse:</b> Use cooled green tea as a face rinse to reduce inflammation.</li>
            </ul>
            <p><i>Tip:</i> Avoid touching your face often and keep your pillowcase clean.</p>
        """
            ),
            HomeRemedy(
                remediesId = "12349",
                title = "Hair Fall Control",
                category = "Hair Care",
                categoryColor = "#9C27B0",
                shortDescription = "Natural oils and ingredients to strengthen hair and reduce fall.",
                description = """
            <h3>Home Remedies for Hair Fall</h3>
            <p>Strengthen hair naturally and prevent breakage with these remedies.</p>
            <ul>
                <li><b>Coconut Oil Massage:</b> Warm oil massage improves blood circulation and growth.</li>
                <li><b>Amla Juice:</b> Apply amla (gooseberry) paste or drink its juice for stronger roots.</li>
                <li><b>Fenugreek Paste:</b> Soak methi seeds overnight, grind and apply on scalp for 20 minutes.</li>
            </ul>
            <p><i>Tip:</i> Avoid harsh shampoos and heat styling tools.</p>
        """
            ),
            HomeRemedy(
                remediesId = "12310",
                title = "Sore Throat Remedy",
                category = "Respiratory",
                categoryColor = "#03A9F4",
                shortDescription = "Gargle and herbal solutions to ease throat pain and irritation.",
                description = """
            <h3>Home Remedies for Sore Throat</h3>
            <p>Soothing natural ways to calm irritation and pain.</p>
            <ul>
                <li><b>Salt Water Gargle:</b> Mix ½ tsp salt in warm water and gargle twice daily.</li>
                <li><b>Honey & Warm Water:</b> Drink a mix of honey and warm water to coat the throat.</li>
                <li><b>Turmeric Milk:</b> Drink warm milk with turmeric before bed for faster relief.</li>
            </ul>
            <p><i>Tip:</i> Stay hydrated and avoid spicy foods while healing.</p>
        """
            ),
            HomeRemedy(
                remediesId = "12311",
                title = "Acidity & Heartburn",
                category = "Digestive",
                categoryColor = "#FFC107",
                shortDescription = "Simple natural ways to calm acidity and prevent heartburn.",
                description = """
            <h3>Natural Remedies for Acidity</h3>
            <p>Balance stomach acid naturally with these simple solutions.</p>
            <ul>
                <li><b>Banana:</b> Eat one ripe banana to reduce burning sensation instantly.</li>
                <li><b>Cold Milk:</b> A small glass of cold milk helps neutralize acid.</li>
                <li><b>Coconut Water:</b> Drink twice daily for a cooling and alkaline effect.</li>
            </ul>
            <p><i>Tip:</i> Avoid overeating and late-night meals.</p>
        """
            ),
            HomeRemedy(
                remediesId = "12312",
                title = "Dark Circles Reduction",
                category = "Skin Care",
                categoryColor = "#E91E63",
                shortDescription = "Natural ingredients to reduce under-eye puffiness and dark circles.",
                description = """
            <h3>Home Remedies for Dark Circles</h3>
            <p>Use natural cooling agents to lighten and refresh the under-eye area.</p>
            <ul>
                <li><b>Cucumber Slices:</b> Place chilled slices for 10–15 minutes daily.</li>
                <li><b>Potato Juice:</b> Dab with cotton; its enzymes help lighten dark areas.</li>
                <li><b>Almond Oil Massage:</b> Gently massage before bed for better blood flow.</li>
            </ul>
            <p><i>Tip:</i> Get 7–8 hours of sleep daily for visible improvement.</p>
        """
            ),
            HomeRemedy(
                remediesId = "12313",
                title = "Insomnia Relief",
                category = "Sleep Health",
                categoryColor = "#607D8B",
                shortDescription = "Home tips and natural aids to promote better sleep and relaxation.",
                description = """
            <h3>Natural Remedies for Better Sleep</h3>
            <p>Promote peaceful sleep with calming natural ingredients and routines.</p>
            <ul>
                <li><b>Warm Milk with Nutmeg:</b> Drink before bedtime to relax your body.</li>
                <li><b>Lavender Oil:</b> Diffuse or apply diluted oil near the pillow for aroma therapy.</li>
                <li><b>Chamomile Tea:</b> A natural sleep inducer and stress reliever.</li>
            </ul>
            <p><i>Tip:</i> Maintain a fixed sleep schedule and avoid screens before bed.</p>
        """
            ),
            HomeRemedy(
                remediesId = "12314",
                title = "Boost Immunity Naturally",
                category = "Immunity",
                categoryColor = "#4CAF50",
                shortDescription = "Simple herbal drinks and foods to strengthen your immune system.",
                description = """
            <h3>Home Remedies to Boost Immunity</h3>
            <p>Include these daily to keep your immune system strong and active.</p>
            <ul>
                <li><b>Tulsi Tea:</b> Boil tulsi leaves in water; drink daily for protection against infections.</li>
                <li><b>Turmeric Water:</b> Mix turmeric in warm water each morning for detox.</li>
                <li><b>Gooseberry (Amla):</b> Rich in Vitamin C, eat one daily to boost resistance.</li>
            </ul>
            <p><i>Tip:</i> Stay hydrated and maintain a balanced diet rich in fruits and greens.</p>
        """
            )
        )

        val hospitalList = HomeListRemediesListAdapter(context, homeRemediesList, this)
        binding.homeRemediesRv.adapter = hospitalList
        binding.homeRemediesRv.layoutManager = LinearLayoutManager(context)
    }

    fun showRemedyDialog(context: Context, remedy: HomeRemedy) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_remedy_details, null)

        val tvTitle = dialogView.findViewById<TextView>(R.id.tvTitle)
        val tvCategory = dialogView.findViewById<TextView>(R.id.tvCategory)
        val webView = dialogView.findViewById<WebView>(R.id.webViewDescription)
        val btnClose = dialogView.findViewById<Button>(R.id.btnClose)

        tvTitle.text = remedy.title
        tvCategory.text = remedy.category
        tvCategory.setTextColor(Color.parseColor(remedy.categoryColor))

        webView.settings.javaScriptEnabled = false
        webView.loadDataWithBaseURL(
            null,
            "<style>body{font-size:15px;color:#333333;line-height:1.5;}</style>${remedy.description}",
            "text/html",
            "utf-8",
            null
        )

        val alertDialog = AlertDialog.Builder(context, R.style.CustomAlertDialog)
            .setView(dialogView)
            .create()

        alertDialog.show()

        btnClose.setOnClickListener { alertDialog.dismiss() }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeRemediesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeRemediesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onRemediesCLick(remedy: HomeRemedy) {
        context?.let { showRemedyDialog(it, remedy) }
    }
}