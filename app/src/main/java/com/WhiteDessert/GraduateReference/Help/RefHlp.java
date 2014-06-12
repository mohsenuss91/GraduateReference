package com.WhiteDessert.GraduateReference.Help;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import com.WhiteDessert.GraduateReference.DataBase.ReferenceDB;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.whitedessert.graduatereference.R;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * Created by yazeed on 04/04/14.
 */
public final class RefHlp {

    // class to help me in basic things

    // note : yazeed when i on xubuntu 13.10 , yazeed44 on xubuntu 14.04


    // Create an ad request
    public final static AdRequest AD_REQUEST = new AdRequest.Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build();

    /* Your ad unit id. Replace with your actual ad unit id. */
    public static final String AD_UNIT_ID = "ca-app-pub-2927841528203268/8926144834";


    public final static Comparator<University> COMPRATOR_UNIV = new Comparator<University>() {
        @Override
        public int compare(University o1, University o2) {
            return o1.getRank().compareTo(o2.getRank());
        }
    };


    public static AdView getAdView(Activity activity){
        AdView adView = new AdView(activity);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId(AD_UNIT_ID);

     //   adView.loadAd(AD_REQUEST);

        return adView;
    }


    public static MuslimScientist[] getScientists(){

        final MuslimScientist[] scientists = {new MuslimScientist(R.drawable.abbas_bin_firnas,"عباس بن فرناس","في الكيمياء: أستنبط الزجاج من الحجارة. في الفلك : صنع آلة لحساب الزمن ومثَّل في بيته السماء بنجومها وغيومها وبروقها ورعودها.في الطيران: حاول الطيران بكسوة جسمه بالحرير " +
                "وألصق عليه ريشاً ومّد لنفسه جناحين متحركين ولم يجعل لنفسه ذنباً فلما ألقى بنفسه من شاهق سقط ومات شهيد العلم +","https://ar.wikipedia.org/wiki/%D8%B9%D8%A8%D8%A7%D8%B3_%D8%A8%D9%86_%D9%81%D8%B1%D9%86%D8%A7%D8%B3"),
                new MuslimScientist(R.drawable.muslimh_almgerte,"مسلمة المجريطي","في الفلك : أوسع الأندلسيين إحاطة بعلم الفلك وحركات النجوم، ويعتبر المجريطي من نوابغ علماء العرب والمسلمين في الأندلس إذ كان موسوعة زمانه في جميع فروع المعرفة" +

                        "كان له ريادة في حقل الكيمياء . نال المجريطي شهرة عظيمة بتحضيره أكسيد الزئبق . بالإضافة إلى ضلوعه في علم الكيمياء . يعتبر المجريطي من ألمع علماء الأندلس في الفلك والرياضيات والكيمياء والمنطق"
              ,"https://ar.wikipedia.org/wiki/%D9%85%D8%B3%D9%84%D9%85%D8%A9_%D8%A7%D9%84%D9%85%D8%AC%D8%B1%D9%8A%D8%B7%D9%8A"  ),
        new MuslimScientist(R.drawable.alzhrawe,"أبو القاسم الزهراوي"," أول من ألف في الجراحة من العرب، أول من أستعمل ربط الشريان بخيط من الحرير،" +
                " أول من أوقف النزيف بالكيّ، وقد توسع باستعماله في فتح الجراحات وإستئصال السرطان،صنع الكثير من اﻷدوات الجراحية،" +
                " أهتم بطبابة الأسنان وأستعمل الكلاليب لقلعها , " +
                " أستأصل اللوزتين، صنع آلة لاستخراج الجنين في حال الولادة المستعصية،" +
                " أو في إزالة الدم من تجويف الصدر أو من الجروح، أول من أجرى عمليات تفتيت الحصاة في المثانة"
      ,"https://ar.wikipedia.org/wiki/الزهراوي"  ),

                new MuslimScientist(R.drawable.jaber_bin_heian,"جابر بن حيان","في الكيمياء : أول من أستحضر ماء الذهب , نجح في وضع أول طريقة للتقطير في العالم.فقد اخترع جهاز تقطير ويستخدم فيه جهاز زجاجي له قمع طويل لا يزال يعرف حتى اليوم في الغرب باسم \"Alembic\" من \"الأمبيق\" باللغة العربية" +
                        "وهو مخترع القلويات المعروفة في مصطلحات الكيمياء الحديثة باسمها العربي (Alkali)، وماء الفضة  , ولقب بأبي الكيمياء","https://ar.wikipedia.org/wiki/%D8%AC%D8%A7%D8%A8%D8%B1_%D8%A8%D9%86_%D8%AD%D9%8A%D8%A7%D9%86"),

                new MuslimScientist(R.drawable.alkoarzme,"الخوارزمي","ساهم الخوارزمي في الرياضيات، وأرسى الأساس للابتكار في الجبر وعلم المثلثات. " +
                        "" +
                        "في الجبر : ويعتبر الجبر هو النص التأسيسي للجبر الحديث. فهو قدم بيانا شاملا لحل المعادلات متعددة الحدود حتى الدرجة الثانية ، وعرض طرق أساسية \"للحد\" و\"التوازن\" في إشارة إلى نقل المصطلحات المطروحة إلى الطرف الآخر من المعادلة، أي إلغاء المصطلحات المتماثلة على طرفي المعادلة" ,
                        "https://ar.wikipedia.org/wiki/%D9%85%D8%AD%D9%85%D8%AF_%D8%A8%D9%86_%D9%85%D9%88%D8%B3%D9%89_%D8%A7%D9%84%D8%AE%D9%88%D8%A7%D8%B1%D8%B2%D9%85%D9%8A")
,new MuslimScientist(R.drawable.ibn_haithm,"إبن الهيثم","قدم إسهامات كبيرة في الرياضيات والبصريات  وطب العيون والفلسفة العلمية والإدراك البصري والعلوم بصفة عامة بتجاربه ، " +
                "صحح ابن الهيثم بعض المفاهيم السائدة ,فأثبت ابن الهيثم حقيقة أن الضوء يأتي من الأجسام إلى العين، وإليه ينسب مبادئ اختراع الكاميرا،" +
                " وهو أول من شرّح العين تشريحًا كاملاً ووضح وظائف أعضائها، كما أورد كتابه المناظر معادلة من الدرجة الرابعة حول انعكاس الضوء على المرايا الكروية،" +
                "يعتبر ابن الهيثم المؤسس الأول لعلم المناظر ","https://ar.wikipedia.org/wiki/%D8%A7%D8%A8%D9%86_%D8%A7%D9%84%D9%87%D9%8A%D8%AB%D9%85")

                , new MuslimScientist(R.drawable.ibn_khaldon,"إبن خلدون","يعتبر ابن خلدون مؤسس علم الاجتماع  ومن من أكبر إنجازات ابن خلدون أنه المؤسس الحقيقي لعلم الاجتماع وواضع أسس علم التاريخ. وهو له تقدير كبير عند الغرب." +
                "" +
                "وتعد ترجمة حياة ابن خلدون من أكثر ترجمات شخصيات التاريخ الإسلامي توثيقا ، تحدث ابن خلدون في هذا الكتاب عن الكثير من تفاصيل حياته المهنية في مجال السياسة والتأليف والرحلات","https://ar.wikipedia.org/wiki/%D8%A7%D8%A8%D9%86_%D8%AE%D9%84%D8%AF%D9%88%D9%86")

                , new MuslimScientist(R.drawable.abo_rihan_al_bironi,"أبو الريحان البيروني" , "كان عالم رياضيات وفيزياء وكان له أيضا اهتمامات في مجال الصيدلة" +
                "كتب البيروني العديد من المؤلفات في مسائل علمية  وفلكية وله مساهمات في حساب المثلثات والدائرة وخطوط الطول والعرض، .اشتهر أيضا بكتاباته عن الصيدلة والأدوية كتب في أواخر حياته كتاباً أسماه \"الصيدلة في الطب\" وكان الكتاب عن ماهيات الأدوية ومعرفة أسمائها." +
                "","https://ar.wikipedia.org/wiki/%D8%A3%D8%A8%D9%88_%D8%A7%D9%84%D8%B1%D9%8A%D8%AD%D8%A7%D9%86_%D8%A7%D9%84%D8%A8%D9%8A%D8%B1%D9%88%D9%86%D9%8A")

                ,new MuslimScientist(R.drawable.ibn_sina,"إبن سينا","" +
                "كان طبيب عصره الأوَّل والماهر، ولما ترجمت كتبه أصبح طبيباً عالمياً وعلى مدى أربعمائة عام." +
                "وهو أوَّل من وصف التهاب السحايا، وأظهر الفرق بين التهاب الحجاب الفاصل بين الرئتين والتهاب ذات الجنب." +
                "" +
                "وهو أوَّل من اكتشف الدودة المستديرة أو دودة الإنكلستوما قبل الطبيب الإيطالي روبنتي بأكثر من ثمانمائة سنة." +

                "","https://ar.wikipedia.org/wiki/%D8%A7%D8%A8%D9%86_%D8%B3%D9%8A%D9%86%D8%A7")

          , new MuslimScientist(R.drawable.al_drisi,"الإدريسي","تكلم الإدريسي عن أقاليم العالم كلها وخاصة في أوروبا، وقد صنع الخرائط الدقيقة,وكتب كتاب نزهة المشتاق ,ويمتاز الكتاب بدقته في حساب الأطوال والعروض للبلاد المختلفة." +
                "في الصيدلة: له كتاب في الأدوية المفردة تعرض فيها لمنافعها ومنابتها."
       ,"https://ar.wikipedia.org/wiki/%D8%A7%D9%84%D8%A5%D8%AF%D8%B1%D9%8A%D8%B3%D9%8A" )
        };
        return scientists;
    }

    public static ArrayList<String> getUnivsNames(Context context){
      final  ReferenceDB db = new ReferenceDB(context);
        db.open();
       final ArrayList<String> univNames = db.getUnivsNames();

        db.close();


        return univNames;
    }

    /*public static University[] getUnivs(){
        final   University universities[] = {new University ("جامعة ام القرى" , "مكة", 806, R.drawable.univ_um_qura_makkah,"https://uqu.edu.sa"),
                new University("الجامعة الاسلامية","المدينة المنورة",1147, R.drawable.univ_islamic_madinah,"www.iu.edu.sa") ,
                new University("جامعة الامام محمد بن سعود الاسلامية","الرياض",866, R.drawable.univ_amam_muhammed,"www.imamu.edu.sa"),
                new University("جامعة الملك سعود","الرياض",753, R.drawable.univ_king_saud,"www.ksu.edu.sa"),
                new University("جامعة الملك عبد العزيز","جدة",536, R.drawable.univ_king_abdualaziz,"www.kau.edu.sa")
                , new University("جامعة الملك فهد للبترول والمعادن","الظهران",853, R.drawable.univ_king_fahd_petrol,"www.kfupm.edu.sa"),
                new University("جامعة الملك فيصل","الرياض",893, R.drawable.univ_king_faisal,"www.kfu.edu.sa"),
                new University("جامعة حائل","حائل",3137, R.drawable.univ_hael,"www.uoh.edu.sa"),
                new University("جامعة جازان","جازان",9999, R.drawable.univ_jazan,"www.jazanu.edu.sa"),
                new University("جامعة الجوف","الجوف",2092, R.drawable.univ_jouf,"www.ju.edu.sa"),
                new University("جامعة الباحة","الباحة",9999, R.drawable.univ_bahh,"www.bu.edu.sa"),
                new University("جامعة تبوك","تبوك",8076, R.drawable.univ_tabuk,"www.ut.edu.sa")
                , new University("جامعة نجران","نجران",8104, R.drawable.univ_njran,"www.nu.edu.sa"),
                new University("جامعة الحدود الشمالية","عرعر",9999, R.drawable.univ_northen_border,"www.nbu.edu.sa"),
                new University("جامعة الاميرة نورة بنت عبدالرحمن","الرياض",9999, R.drawable.univ_amerh_norh,"http://www.pnu.edu.sa"),
                new University("جامعة الملك سعود بن عبد العزيز للعلوم الصحية","الرياض / جدة / الأحساء",9999, R.drawable.univ_king_saud_for_medic,"http://www.ksau-hs.edu.sa"),
                new University("جامعة الدمام","الدمام",9999, R.drawable.univ_dammam,"www.ud.edu.sa"),
                new University(" جامعة الامير سلمان ","الخرج",9999, R.drawable.univ_amer_slman,"www.sau.edu.sa"),
                new University("جامعة شقراء","شقراء",9999, R.drawable.univ_shaqra,"www.su.edu.sa")
                , new University("جامعة المجمعة","المجمعة",9999, R.drawable.univ_mjamaa,"www.mu.edu.sa"),
                new University("الجامعة السعودية الالكترونية","",9999, R.drawable.univ_electronic_saudi,"https://www.seu.edu.sa")
                , new University("جامعة الملك خالد","أبها",1364, R.drawable.univ_king_khaled,"www.kku.edu.sa"),
                new University("جامعة القصيم","بريدة",9999, R.drawable.univ_qassim,"www.qu.edu.sa"),
                new University("جامعة طيبة","المدينة المنورة",2909, R.drawable.univ_tybh,"www.taibahu.edu.sa"),
                new University("جامعة الطائف","الطائف",2892, R.drawable.univ_taef,"www.tu.edu.sa")  ,
                new University("جامعة الأمير نايف للعلوم الأمنية","الرياض",3483, R.drawable.univ_naef_security,"www.nauss.edu.sa") ,
                new University("جامعة عفت","جدة",5163, R.drawable.univ_efft,"www.effatuniversity.edu.sa")
                , new University("جامعة الامير سلطان", "الرياض" , 5478, R.drawable.univ_amer_sultan,"www.psu.edu.sa") ,
                new University("جامعة اليمامة" , "الرياض" , 9999, R.drawable.univ_ymamh,"www.yu.edu.sa") ,
                new University("جامعة الملك عبدالله للعلوم والتقنية","جدة",9999, R.drawable.univ_king_abduallah_science,"http://arabic.kaust.edu.sa")
                , new University("جامعة الفيصل" , "الرياض" , 9999, R.drawable.univ_alfaisal,"www.alfaisal.edu") ,
                new University("جامعة الأمير محمد بن فهد","الخبر",9999, R.drawable.univ_amer_mohammed_bin_fahed,"www.pmu.edu.sa"),
                new University("جامعة الأمير فهد بن سلطان","تبوك",9999, R.drawable.univ_fahad_bin_sultan,"www.fbsu.edu.sa")
                , new University("جامعة دار العلوم","الرياض",9999, R.drawable.univ_dar_aolom,"www.dau.edu.sa/ar") ,
                new University("جامعة مكة المكرمة المفتوحة","مكة",9999, R.drawable.univ_makkah_open,null)


        };





        return universities;
    }
*/
    public static MainSpec[] getMainSpecs() {

     final    MainSpec MAIN_SPECS[] = new MainSpec[12];
        Spec techSpec[] = {new Spec("هندسة الميكاترونيكس",new SubSpec[]{}),new Spec("علوم الحاسب الآلي",new SubSpec[]{new SubSpec("شبكات"),new SubSpec("لغات برمجية"),
                new SubSpec("نظم معلومات"),new SubSpec("ذكاء إصطناعي"),new SubSpec("قواعد بيانات"),new SubSpec("أمن معلومات"),}),

                new Spec("العمارة",new SubSpec[]{}),
                new Spec("الهندسة الكيميائية",new SubSpec[]{new SubSpec("الأغذية") ,new SubSpec("المواد الاستهلاكية"),new SubSpec("الأدوية"),new SubSpec("مواد التجميل"),new SubSpec("البتروكيماويات"),
                }), new Spec("الهندسة المدنية",new SubSpec[]{new SubSpec("الهندسة الأنشائية"),new SubSpec("الهندسة الجيوتكنيكية"),
                new SubSpec("هندسة النقل"),new SubSpec("هندسة النقل"),
                new SubSpec("هندسة التشييد"),new SubSpec("هندسة مصادر المياه"),new SubSpec("هندسة البيئة"),new SubSpec("الهندسة الحضرية"),}),

                new Spec("الهندسة المعمارية",new SubSpec[]{}),
                new Spec("هندسة التعدين (المعادن)",new SubSpec[]{new SubSpec("ميكانيكا الصخور"),new SubSpec("تنقيب عن خامات"),new SubSpec("هندسة مناجم سطحية"),new SubSpec("هندسة مناجم تحت سطحية"),}),

                new Spec("تقنية معلومات",new SubSpec[]{}),new Spec("هندسة أنظمة تحكم وقياس",new SubSpec[]{}),
                new Spec("هندسة صناعية",new SubSpec[]{}),
                new Spec("الهندسة النووية",new SubSpec[]{}),
                new Spec("الهندسة الطبية الحيوية",new SubSpec[]{new SubSpec("الهندسة الكهربائية الطبية"),new SubSpec("الهندسة الميكانيكية الحيوية"),new SubSpec("هندسة المواد الحيوية"),
                        new SubSpec("هندسة النسج والجزيئات والخلايا"),new SubSpec("هندسة محاكاة الأنظمة الحيوية"),}),

                new Spec("هندسة الحاسب الآلي",new SubSpec[]{}),
                new Spec("هندسة الطيران والفضاء",new SubSpec[]{new SubSpec("هندسة الطيران"),new SubSpec("هندسة الفضاء"),}),

                new Spec("هندسة المساحة",new SubSpec[]{new SubSpec("المساحة المستوية"),new SubSpec("المساحة الجيوديسية"),new SubSpec("المساحة التصويرية الجوية"),new SubSpec("الاستشعار عن بعد"),
                        new SubSpec("نظام تحديد المواقع العالمي"),new SubSpec("نظم المعلومات الجغرافية"),}),

                new Spec("هندسة الوقاية الإشعاعية",new SubSpec[]{}),
                new Spec("هندسة برمجيات الحاسب",new SubSpec[]{}),new Spec("هندسة بيئية",new SubSpec[]{}),
                new Spec("التصميم الداخلي (الديكور)",new SubSpec[]{}),
                new Spec("الهندسة الميكانيكية",new SubSpec[]{new SubSpec("قوى ميكانيكية"),new SubSpec("تبرييد وتكييف"),}),

                new Spec("هندسة حرارية وتحلية المياه",new SubSpec[]{}),
                new Spec("الهندسة الالكترونية",new SubSpec[]{new SubSpec("النظام الرقمي"),new SubSpec("أشباه الموصلات"),new SubSpec("إلكترونيات دقيقة"),new SubSpec("أنظمة التحكم والروبوت"),}),

                new Spec("تخطيط المدن و الأقاليم",new SubSpec[]{}),
                new Spec("هندسة الاتصالات",new SubSpec[]{new SubSpec("الاتصالات الـلاسلاكية"),new SubSpec("اتصالات الهاتف المحمول"),new SubSpec("الأفمار الصناعية والبث الفضائية"),
                        new SubSpec("هندسة الهوائيات"),new SubSpec("هندسة المايكرويف"),}),

                new Spec("هندسة البترول",new SubSpec[]{new SubSpec("هندسة الحفر"),new SubSpec("هندسة الإنتاج"),new SubSpec("هندسة الخزان"),new SubSpec("الهندسة البتروفيزيائية"),})

                , new Spec("إدارة هندسية",new SubSpec[]{}),
                new Spec("الأمن الصناعي والسلامة المهنية",new SubSpec[]{}),
        };
        MAIN_SPECS[0] = new MainSpec("الهندسة والتكنولوجيا", techSpec);

        Spec humanHealth[] = {new Spec("الطب البشري",new SubSpec[]{new SubSpec("الطب الباطني"),new SubSpec("الجراحة العامة"),new SubSpec("جراحة المخ والأعصاب"),new SubSpec("الأشعة"),
                new SubSpec("طب الأنف والأذن والحنجرة"),new SubSpec("التخدير"),new SubSpec("طب الأورام"),new SubSpec("طب الأطفال"),
                new SubSpec("طب النساء والولادة"),new SubSpec("الطب النفسي"),new SubSpec("طب وجراحة العيون"),new SubSpec("جراحة العظام"),new SubSpec("طب أمراض الجلد"),
                new SubSpec("علم الأمراض والمختبرات")})

                ,new Spec("التمريض",new SubSpec[]{new SubSpec("تمريض أمراض باطنية"),new SubSpec("تمريض صحة المجتمع"),new SubSpec("تمريض الصحة النفسية"),new SubSpec("تمريض صحة الأمومة والطفولة"),
                new SubSpec("تمريض جراحي"),new SubSpec("تمريض حديثي الولادة"),new SubSpec("تمريض العناية المركزة"),}),

                new Spec("الصيدلة",new SubSpec[]{new SubSpec("الصيدلة الإكلينيكية"),new SubSpec("الصيدلانيات"),new SubSpec("تكنولوجيا الأدوية"),
                        new SubSpec("الكيمياء الصيدلية"),new SubSpec("الصيدلية الطبيعية والطب البديل"),new SubSpec("العقاقير"),
                        new SubSpec("الكيمياء التحليلية الصيدلية"),new SubSpec("السموم"),}),

                new Spec("تقنية الأسنان",new SubSpec[]{new SubSpec("التركيبات الكاملة"),new SubSpec("التركيبات المتحركة"),new SubSpec("التركيبات الثابتة"),
                        new SubSpec("التقويم"),new SubSpec("استعاضات الوجه و الفكين"),}),

                new Spec("صحة الأسنان",new SubSpec[]{}),
                new Spec("البصريات",new SubSpec[]{new SubSpec("بصريات الشيخوخة"),new SubSpec("عيوب عضلات العين"),new SubSpec("بصريات الألوان"),new SubSpec("العدسات الـلاصقة"),}),

                new Spec("التغذية",new SubSpec[]{new SubSpec("التغذية السريرية"),new SubSpec("تغذية المجتمع والمجموعات"),new SubSpec("التغذية لدى شركات التغذية"),
                        new SubSpec("التغذية في الطب البديل"),new SubSpec("التغذية لدى كبار السن"),new SubSpec("التغذية لدى الأطفال"),}),

                new Spec("سمعيات",new SubSpec[]{}),
                new Spec("طب الأسنان",new SubSpec[]{new SubSpec("العلاج التحفظي"),new SubSpec("التركيبات المتحركة والثابتة والأطقم الكاملة"),
                        new SubSpec("تقويم الأسنان"),new SubSpec("جراحة الوجه والفكين"),new SubSpec("طب أسنان الأطفال"),}),

                new Spec("علل النطق والتخاطب",new SubSpec[]{new SubSpec("أمراض واضطرابات الصوت"),new SubSpec("أمراض اللغة"),new SubSpec("أمراض واضطرابات الكلام"),new SubSpec("أمراض واضطراب البلع"),}),

                new Spec("الأشعة",new SubSpec[]{new SubSpec("الأشعة السينية"),new SubSpec("الموجات الفوق الصوتية"),new SubSpec("الرنين المغناطيسي"),new SubSpec("الأشعة المقطعية"),new SubSpec("الطب النووي"),}),

                new Spec("الأطراف الصناعية والجبائر",new SubSpec[]{}),
                new Spec("التثقيف الصحي",new SubSpec[]{new SubSpec("التثقيف الصحي الاكلينيكي"),new SubSpec("التثقيف الصحي في الخدمات الصحية الوقائية"),
                        new SubSpec("التثقيف الصحي المدرسي"),new SubSpec("التثقيف الصحي المهني وقضايا السلامة"),new SubSpec("التثقيف الصحي الموجه للمجتمعات")}),

                new Spec("الصيدلة السريرية ( دكتور صيدلي )",new SubSpec[]{}),
                new Spec("العلاج التنفسي",new SubSpec[]{}),
                new Spec("العلاج الطبيعي",new SubSpec[]{new SubSpec("العلاج الطبيعي للأطفال"),new SubSpec("العلاج الطبيعي للعظام والعضلات والمفاصل"),new SubSpec("العلاج الطبيعي لكبار السن"),
                        new SubSpec("العلاج الطبيعي لإصابات الجهاز العصبي"),new SubSpec("العلاج الطبيعي لأمراض القلب والصدر")})

                ,new Spec("العلاج الوظيفي",new SubSpec[]{}),
                new Spec("علوم المختبرات الطبية",new SubSpec[]{new SubSpec("علم الأحياء الدقيقة الطبية"),new SubSpec("علم الكيمياء الحيوية الإكلينيكية"),new SubSpec("علم أمراض الدم"),new SubSpec("بنوك الدم"),
                        new SubSpec("علم الأنسجة والخلايا المرضية"),new SubSpec("علم المناعة والمصليات"),new SubSpec("علم الوراثة وعلم الوراثة الجزيئية")}),

                new Spec("الطوارئ والإسعاف",new SubSpec[]{new SubSpec("طب طوارئ الأطفال"),new SubSpec("علم الإصابات"),new SubSpec("طوارئ الكبار"),new SubSpec("طوارئ الأمراض النفسية"),}),

                new Spec("صحة عامة",new SubSpec[]{new SubSpec("علم الوبائيات"),new SubSpec("علم الوقاية ومكافحة العدوى"),new SubSpec("الإحصاء الحيوي"),new SubSpec("علم صحة البيئة"),new SubSpec("صحة المجتمع"),
                        new SubSpec("صحة الأمومة والطفولة"),new SubSpec("السياسات الصحية العامة"),new SubSpec("الصحة المهنية")}),

                new Spec("طب بديل",new SubSpec[]{})};

        MAIN_SPECS[1] = new MainSpec("صحة الإنسان",humanHealth);


        Spec militarySpec[] = {new Spec("العلوم الأمنية",new SubSpec[]{new SubSpec("الشرطة"),new SubSpec("الاستخبارات"),new SubSpec("الجوازات"),
                new SubSpec("الدفاع المدني"),new SubSpec("الأمن العام"),new SubSpec("الأمن الجنائي"),}),

                new Spec("العلوم الجنائية",new SubSpec[]{}),
                new Spec("العلوم العسكرية",new SubSpec[]{new SubSpec("التكتيك"),new SubSpec("قراءة الخرائط"),new SubSpec("الأسلحة"),new SubSpec("الإشارة"),}),};


        MAIN_SPECS[2] = new MainSpec("العسكرية والأمن",militarySpec);

        Spec shariaaSpec[] = {new Spec("أصول الدين",new SubSpec[] {new SubSpec("قسم القرآن وعلومه"),new SubSpec("قسم السنة وعلومها"),new SubSpec("قسم العقيدة والمذاهب المعاصرة"),}),
                new Spec("القرآن الكريم",new SubSpec[] {new SubSpec("تفسير القرآن"),new SubSpec("القراءات"),}),
                new Spec("الدعوة",new SubSpec[] {}),
                new Spec("الشريعة",new SubSpec[] {new SubSpec("الفقه الإسلامي"),new SubSpec("أصول الفقه"),new SubSpec("الاقتصاد الإسلامي"),}),};

        MAIN_SPECS[3] = new MainSpec("العلوم الشرعية",shariaaSpec);

        SubSpec external = new SubSpec("الجيوفيزياء الخارجية"), internal = new SubSpec("الجيوفيزياء الداخلية");

        internal.setHint("تدرس سطح وباطن الارض"); external.setHint("تهتم بدراسة التغيرات المناخية");

        Spec scienceSpec[] = {new Spec("فيزياء الأرض (جيوفيزياء)",new SubSpec[]{internal,external}),

                new Spec("أحياء",new SubSpec[]{new SubSpec("علم الخلية"),new SubSpec("بيولوجية جزيئية"),new SubSpec("الوراثة"),new SubSpec("علم الحيوان"),
                        new SubSpec("علم النبات"),new SubSpec("علم الأحياء الدقيقة"),}),

                new Spec("علم الفيزياء",new SubSpec[]{new SubSpec("الفيزياء النظرية"),new SubSpec("الجوامد"),new SubSpec("الضوء"),new SubSpec("كهرومغناطيسية"),new SubSpec("نووية"),
                        new SubSpec("فيزياء الطاقة الشمسية"),new SubSpec("الليزر"),new SubSpec("الإلكترونيات"),new SubSpec("فيزياء النانو"),new SubSpec("فيزياء البلازما"),new SubSpec("فيزياء الكم"),
                        new SubSpec("الفيزياء الإشعاعية"),new SubSpec("فيزياء طبية"),}),

                new Spec("الكيمياء الحيوية",new SubSpec[]{new SubSpec("الكيمياء الجزيئية"),new SubSpec("التقنيات الحيوية"),new SubSpec("كيمياء الإنزيمات"),new SubSpec("الأحياء الجزيئية"),}),

                new Spec("الكيمياء الصناعية",new SubSpec[]{}),
                new Spec("الكيمياء",new SubSpec[]{new SubSpec("الكيمياء العضوية"),new SubSpec("الكيمياء الغير عضوية"),new SubSpec("الكيمياء الفيزيائية"),new SubSpec("الكيمياء التحليلية"),}),

                new Spec("علم الحيوان",new SubSpec[]{new SubSpec("البيئة الحيوانية والتلوث"),new SubSpec("بيولوجيا الخلية"),new SubSpec("الوراثة والأنسجة"),
                        new SubSpec("علم وظائف الأعضاء وبيولوجية التكوين والأجنة"),
                        new SubSpec("الحشرات والطفيليات"),new SubSpec("الأحياء المائية"),new SubSpec("علم الطيور"),}),

                new Spec("علم الأحياء الدقيقة",new SubSpec[]{new SubSpec("البكتيريا"),new SubSpec("الطفيليات"),new SubSpec("الفيروسات"),
                        new SubSpec("الطحالب"),new SubSpec("المناعة"),new SubSpec("التقنية الحيوية"),}),

                new Spec("الرياضيات",new SubSpec[]{new SubSpec("الرياضيات البحتة"),new SubSpec("الرياضيات التطبيقية"),new SubSpec("الرياضيات المالية"),new SubSpec("الرياضيات الكمة"),
                        new SubSpec("الرياضيات الفراغية"),
                        new SubSpec("الجبر"),new SubSpec("الهندسة"),new SubSpec("الإحصاء وبحوث العمليات"),}),

                new Spec("الفيزياء الطبية",new SubSpec[]{new SubSpec("فيزياء العلاج الإشعاعي"),new SubSpec("فيزياء الطب النووي"),new SubSpec("فيزياء الإشعة التشخيصية"),
                        new SubSpec("فيزياء الرنين المغناطيسي"),new SubSpec("الوقاية من الإشعاع"),}),

                new Spec("علم الفلك",new SubSpec[]{new SubSpec("الدراسات الشمسية"),new SubSpec("الميكانيكا السماوية"),new SubSpec("علوم الكون"),new SubSpec("الفلك الفيزيائي"),
                        new SubSpec("فيزياء وديناميكا الفضاء"),new SubSpec("أقمار صناعية"),new SubSpec("القياس الفلكي"),}),

                new Spec("علوم الأرض (الجيولوجيا)",new SubSpec[]{new SubSpec("تخصص جيلوجيا الثروة المعدنية والصخور"),new SubSpec("تخصص الجيولوجيا البنائية والأستشعار عن بعد"),
                        new SubSpec("تخصص الجيولوجيا الهندسية"),
                        new SubSpec("تخصص جيولوجيا البترول والترسبات"),new SubSpec("تخصص جيولوجيا المياه"),}),

                new Spec("العلوم الطبية الأساسية",new SubSpec[]{}),new Spec("علم الوراثة",new SubSpec[]{})};

        MAIN_SPECS[4] = new MainSpec("العلوم", scienceSpec);


        Spec[] socialSpec = {new Spec("المكتبات والمعلومات",new SubSpec[]{new SubSpec("بنوك المعلومات"),new SubSpec("المخطوطات والوثائق القديمة")}),

                new Spec("العلوم السياسية",new SubSpec[]{new SubSpec("علاقات دولية"),new SubSpec("النظريات والأيديولوجيات السياسية"),new SubSpec("حقوق الأنسان"),new SubSpec("الحكومات والأنظمة السياسية"),
                        new SubSpec("السياسة المقارنة"),new SubSpec("الاقتصاد السياسي"),new SubSpec("علم الاجتماع السياسي"),new SubSpec("علم النفس السياسي"),}),

                new Spec("القانون",new SubSpec[]{new SubSpec("القانون العام"),new SubSpec("القانون المدني"),new SubSpec("القانون التجاري"),new SubSpec("القانون الجنائي"),new SubSpec("القانون الدولي"),}),

                new Spec("علم الاجتماع",new SubSpec[]{new SubSpec("علم الاجتماع الحضري"),new SubSpec("علم الاجتماع الثقافي"),new SubSpec("علم الاجتماع الطبي"),new SubSpec("علم الاجتماع التربوي"),
                        new SubSpec("علم اجتماع الاتصال"),new SubSpec("علم اجتماع التنظيم والعمل"),new SubSpec("علم الاجتماع السياسي"),new SubSpec("علم الاجتماع الاقتصادي"),}),

                new Spec("علم النفس",new SubSpec[]{new SubSpec("علم النفس السريري"),new SubSpec("علم نفس النمو"),new SubSpec("علم نفس الصناعي"),new SubSpec("علم النفس الإرشادي"),new SubSpec("علم النفس الجنائي"),
                        new SubSpec("علم النفس التربوي"),new SubSpec("علم النفس الإجتماعي"),new SubSpec("علم نفس الشخصية"),new SubSpec("علم النفس الرياضي"),new SubSpec("علم النفس المهني"),}),

                new Spec("التاريخ",new SubSpec[]{new SubSpec("التاريخ السياسي"),new SubSpec("التاريخ الاقتصادي"),new SubSpec("التاريخ الاجتماعي"),
                        new SubSpec("التاريخ الإسلامي"),new SubSpec("تاريخ أوروبا"),new SubSpec("تاريخ العلوم"),}),

                new Spec("الجغرافيا",new SubSpec[]{new SubSpec("نظم معلومات جغرافية"),new SubSpec("البيئة والموارد الطبيعية"),new SubSpec("جغرافية العمران والسكان"),
                        new SubSpec("الجغرافية الاقتصادية والتنمية الإقليمية"),new SubSpec("الخرائط"),}),

                new Spec("الخدمة الاجتماعية",new SubSpec[]{new SubSpec("خدمة الأفراد"),new SubSpec("خدمة الجماعة"),new SubSpec("خدمة اجتماعية طبية"),new SubSpec("خدمة اجتماعية تأهيلية"),
                        new SubSpec("خدمة اجتماعية مدرسية"),new SubSpec("إدارة مؤسسات اجتماعية"),}),

                new Spec("الفلسفة",new SubSpec[]{new SubSpec("فلسفة العلوم"),new SubSpec("فلسفة المنطق"),new SubSpec("فلسفة اللغة"),new SubSpec("علم الجمال"),}),

                new Spec("علم سلالات الإنسان (علم الأنثروبولوجيا)",new SubSpec[]{new SubSpec("علم الأنثروبولجيا الطبية"),new SubSpec("علم الأنثروبولوجيا الطب شرعية"),
                        new SubSpec("علم الأنثروبولوجيا الاجتماعية"),new SubSpec("علم الأنثروبولوجيا البيولوجية"),})

                ,new Spec("علوم الأديان",new SubSpec[]{}),new Spec("إدارة السكن والمؤسسات",new SubSpec[]{}),
        new Spec("دراسات المرأة",new SubSpec[]{})};


        MAIN_SPECS[5] = new MainSpec("العلوم الاجتماعية والإنسانية",socialSpec);


        Spec bussinessSpec[] = {new Spec("إدارة الموارد البشرية",new SubSpec[]{}),new Spec("الاقتصاد",new SubSpec[]{new SubSpec("الاقتصاد السياسي"),
                new SubSpec("اقتصاد الطاقة"),new SubSpec("البنوك"),new SubSpec("المالية العامة"),new SubSpec("التمويل"),new SubSpec("اقتصاد البيئة والموارد الطبيعية"),
                new SubSpec("التجارة الإلكترونية"),new SubSpec("التجارة العالمية"),}),

                new Spec("إدارة الأعمال",new SubSpec[]{new SubSpec("التمويل"),new SubSpec("الموارد البشرية"),new SubSpec("التسويق"),
                        new SubSpec("المبيعات"),new SubSpec("التخطيط الاستراتيجي"),new SubSpec("المالية"),new SubSpec("إعلان"),new SubSpec("التأمين وإدارة المخاطر")}),

                new Spec("إدارة أعمال دولية",new SubSpec[]{}),
                new Spec("إدارة الخدمات الصحية (إدارة المستشفيات)",new SubSpec[]{new SubSpec("إدارة الجودة الشاملة"),new SubSpec("إقتصاديات الصحة"),}),

                new Spec("إدارة عامة",new SubSpec[]{}),
                new Spec("العلوم المصرفية (بنوك)",new SubSpec[]{}),new Spec("تأمين ودراسات الاكتواري",new SubSpec[]{}),
                new Spec("نظم المعلومات الإدارية",new SubSpec[]{}),
                new Spec("الإحصاء",new SubSpec[]{new SubSpec("الإحصاء الحيوي"),new SubSpec("الإحصاء الرياضي"),new SubSpec("الإحصاء البيئي"),
                        new SubSpec("الإحصاء الاجتماعي"),new SubSpec("الإحصاء الاقتصادي")}),

                new Spec("المحاسبة",new SubSpec[]{new SubSpec("المحاسبة المالية"),new SubSpec("المحاسبة الإدارية"),
                        new SubSpec("حوكمة الشركات"),new SubSpec("التدقيق"),new SubSpec("الضرائب"),new SubSpec("التأمين"),}),

                new Spec("تمويل واستثمار",new SubSpec[]{}),
                new Spec("العلوم المالية",new SubSpec[]{new SubSpec("رياضيات مالية"),new SubSpec("إدارة مالية"),new SubSpec("أسهم ومستندات"),new SubSpec("استثمار"),
                        new SubSpec("الأعمال البنكية"),new SubSpec("مالية الشركات"),}),

                new Spec("التسويق",new SubSpec[]{new SubSpec("المبيعات"),new SubSpec("أبحاث التسويق"),new SubSpec("الدعاية والإعلان"),new SubSpec("البيع بالتجزئة"),
                        new SubSpec("علاقات العملاء"),new SubSpec("إدارة العملاء التجارية"),new SubSpec("التسويق الدولي"),}),

                new Spec("علاقات عامة",new SubSpec[]{}),new Spec("إدارة اللوجستيات وسلاسل الإمدادات",new SubSpec[]{}),};

        MAIN_SPECS[6] = new MainSpec("عالم الإدارة والمال واﻷعمال", bussinessSpec);

        Spec educationSpec[] = {new Spec("الاقتصاد المنزلي (تربية)",new SubSpec[]{}),
                new Spec("تربية خاصة",new SubSpec[]{new SubSpec("الإعاقة البصرية"),new SubSpec("الإعاقة السمعية"),new SubSpec("التخلق العقلي"),new SubSpec("التفوق والابتكار"),
                        new SubSpec("صعوبات التعلم"),new SubSpec("التوحد والاضطرابات السلوكية"),}),

                new Spec("أحياء (تربية)",new SubSpec[]{}),
                new Spec("حاسب آلي(تربية)",new SubSpec[]{}),
                new Spec("دراسات إسلامية(تربية)",new SubSpec[]{}),
                new Spec("دراسات قرآنية (تربية)",new SubSpec[]{}),new Spec("رياضيات (تربية)",new SubSpec[]{}),new Spec("علوم اجتماعية (تربية)",new SubSpec[]{}),
                new Spec("فيزياء (تربية)",new SubSpec[]{}),new Spec("كيمياء (تربية)",new SubSpec[]{}),
                new Spec("طفولة مبكرة (رياض الأطفال)",new SubSpec[]{new SubSpec("مناهج وطرق تدريس"),new SubSpec("علم نفس النمو"),new SubSpec("صعوبات التعلم"),}),

                new Spec("التربية",new SubSpec[]{new SubSpec("علم النفس التربوي"),new SubSpec("مناهج وطرق تدريس"),new SubSpec("إدارة تربوية"),}),

                new Spec("تربية بدنية",new SubSpec[]{}),
                new Spec("تربية فنية",new SubSpec[]{}),new Spec("لغة إنجليزية (تربية)",new SubSpec[]{}),
                new Spec("لغة عربية (تربية)",new SubSpec[]{}),new Spec("تكنولوجيا التعليم",new SubSpec[]{}),

                new Spec("التعليم الابتدائي",new SubSpec[]{new SubSpec("الدراسات القرآنية"),new SubSpec("الرياضيات"),new SubSpec("العلوم"),new SubSpec("اللغة العربية"),}),
                };

        MAIN_SPECS[7] = new MainSpec("التعليم",educationSpec);


        Spec farmSpec[]= {new Spec("الهندسة الزراعية",new SubSpec[]{new SubSpec("هندسة الآلات والقوى"),new SubSpec("هندسة نظم المياه والري"),new SubSpec("هندسة تصنيع الأغذية"),
                new SubSpec("هندسة المنشآت الزراعية والتحكم البيئي"),}),

                new Spec("نبات",new SubSpec[]{new SubSpec("فسيولوجيا النبات"),new SubSpec("تصنيف النبات"),new SubSpec("أمراض النبات"),new SubSpec("علم الوراثة"),new SubSpec("أقلمة النبات"),}),

                new Spec("طب بيطري",new SubSpec[]{new SubSpec("دواجن ومجترات"),new SubSpec("حيوانات برية"),new SubSpec("أسماك"),new SubSpec("الطب العيادي"),new SubSpec("الجراحة"),
                        new SubSpec("التوليد والأمراض التناسلية"),new SubSpec("طب الحالات الطارئة والعناية الحثيثة")}),

                new Spec("عمارة البيئة",new SubSpec[]{}),
                new Spec("إرشاد زراعي",new SubSpec[]{}),

                new Spec("علوم بيئية وصحة البيئة",new SubSpec[]{new SubSpec("إدارة البيئة"),new SubSpec("كيمياء وبيولوجيا البيئة"),new SubSpec("تلوث الهواء"),new SubSpec("الصحة المهنية"),}),

                new Spec("اقتصاد زراعي",new SubSpec[]{new SubSpec("سياسات زراعية"),new SubSpec("تنمية زراعية"),new SubSpec("اقتصاديات الإنتاج"),new SubSpec("تسويق زراعي"),
                        new SubSpec("اقتصاد موارد زراعية"),new SubSpec("جدوى اقتصادية زراعية"),}),

                new Spec("زراعة المناطق الجافة",new SubSpec[]{new SubSpec("علم البساتين"),new SubSpec("علم التربة"),}),

                new Spec("إنتاج حيواني",new SubSpec[]{new SubSpec("الدواجن"),new SubSpec("الأسماك"),new SubSpec("الحيوانات المجترة"),new SubSpec("تقنيات الهندسة الوراثية"),
                        new SubSpec("تغذية الحيوان"),new SubSpec("وظائف الأعضاء للحيوانات والدواجن"),new SubSpec("رعاية الحيوان"),}),

                new Spec("إنتاج النبات ووقايته",new SubSpec[]{new SubSpec("البيوت المحمية"),new SubSpec("إنتاج حبوب"),new SubSpec("آفات زراعية"),new SubSpec("وقاية النبات"),}),

                new Spec("بساتين",new SubSpec[]{new SubSpec("زينة"),new SubSpec("الخضر"),new SubSpec("الفاكهة"),}),

                new Spec("تربة ومياه",new SubSpec[]{}),

                new Spec("علوم البحار",new SubSpec[]{new SubSpec("الأحياء البحرية"),new SubSpec("الفيزياء البحرية"),new SubSpec("الكيمياء البحرية"),
                        new SubSpec("الجيولوجيا البحرية"),new SubSpec("الدراسات البحرية"),}),};

        MAIN_SPECS[8] = new MainSpec("الزراعة والبيئة",farmSpec );

        Spec tourismSpec[] = {new Spec("سياحة",new SubSpec[]{}),new Spec("علم الآثار",new SubSpec[]{}),
                new Spec("فندقة",new SubSpec[]{new SubSpec("إدارة المسكن"),new SubSpec("إدارة التسويق"),new SubSpec("إدارة الترفيه"),new SubSpec("إدارة التغذية"),
                        new SubSpec("مالية ومحاسبة الفنادق"),new SubSpec("إدارة المبيعات"),new SubSpec("الموارد البشرية"),}),

                new Spec("إرشاد سياحي",new SubSpec[]{}),};

        MAIN_SPECS[9] = new MainSpec("الفندقة والسياحة",tourismSpec);

        Spec languageSpec[] = {new Spec("اللغة العربية",new SubSpec[]{new SubSpec("النحو والصرف"),new SubSpec("فقه اللغة"),new SubSpec("البلاغة والنقد"),new SubSpec("آداب اللغة العربية"),}),

                new Spec("إذاعة وتلفزيون",new SubSpec[]{}),

                new Spec("الفنون الإسلامية",new SubSpec[]{new SubSpec("الأشغال الفنية البيئية"),new SubSpec("الخزف"),new SubSpec("الرسم والتصوير"),new SubSpec("الطباعة"),new SubSpec("النسيج"),}),

                new Spec("فنون جميلة",new SubSpec[]{}),new Spec("اللغة الإنجليزية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة الإنجليزية"),}),

                new Spec("الترجمة",new SubSpec[]{new SubSpec("ترجمة فورية"),new SubSpec("ترجمة متخصصة"),}),

                new Spec("اللغة الإسبانية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة الإسبانية"),}),

                new Spec("اللغة الألمانية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة الألمانية"),}),

                new Spec("اللغة الإيطالية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة الإيطالية"),}),

                new Spec("اللغة التركية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة التركية"),}),

                new Spec("اللغة الروسية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة الروسية"),}),

                new Spec("اللغة العبرية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة العبرية"),}),

                new Spec("اللغة الفارسية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة الفارسية"),}),

                new Spec("اللغة الفرنسية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة الفرنسية"),}),

                new Spec("اللغة اليابانية",new SubSpec[]{new SubSpec("اللغويات"),new SubSpec("آداب اللغة اليابانية"),}),

                new Spec("الصحافة",new SubSpec[]{new SubSpec("الإعلام السياسي"),new SubSpec("الإعلام الاقتصادي"),new SubSpec("الإعلام الاجتماعي"),new SubSpec("الإعلام الرياضي"),}),

                new Spec("مسرح",new SubSpec[]{}),new Spec("لغات اجنبية أخرى",new SubSpec[]{}),new Spec("الوسائط المتعددة",new SubSpec[]{})
        };

        MAIN_SPECS[10] = new MainSpec(" اللغات والفنون والإعلام", languageSpec);

        SubSpec towerWatcher = new SubSpec("مراقب البرج") , closeWatcher = new SubSpec("مراقب الاقتراب"), areaWatcher = new SubSpec("مراقب المنطقة");
        towerWatcher.setHint("الذي يتحكم في حركة الطائرات على ارض المطار بسلام وإعطاء الإذن بالاقلاع والهبوط في دائرة من 5 إلى 10 أميال وارتفاع من الأرض إلى 5000 قدم حول المطار");
        closeWatcher.setHint("إذ يتحكم في الطائرات القادمة والمغادرة من وإلى المطار من حيث توجيه الطائرات إلى مساراتها أو إلى مدرج الهبوط بسلام ويكون التحكم بالطائرات في دائرة قطرها من 25 إلى 60 ميل حول المطار وبارتفاع محدد من 5000 قدم إلى 15000 قدم");
        areaWatcher.setHint("وهو الذي يتحكم في التوجيه النهائي بالنسبة إلى الطائرات المغادرة ويقوم أيضا بتحويل المسؤولية إلى المنطقة المجاورة يستقبل الطائرات القادمة ويحولها إلى مراقب الاقتراب");

        Spec unfamiliarSpec[] = {new Spec("المراقبة الجوية",new SubSpec[]{towerWatcher,closeWatcher,areaWatcher}),

        new Spec("أساليب كمية",new SubSpec[]{new SubSpec("أساليب كمية ديموغرافية"),new SubSpec("أساليب كمية تجارية")}),

                new Spec("الجودة النوعية",new SubSpec[]{}),new Spec("دراسات وشؤون دولية",new SubSpec[]{new SubSpec("الاقتصاد السياسي الدولي"),new SubSpec("القانون الدولي"),new SubSpec("العولمة"),
                new SubSpec("دراسات دولية"),new SubSpec("المجتمع الدولي"),}),

                new Spec("طيران مدني",new SubSpec[]{}),new Spec("ملابس ونسيج",new SubSpec[]{new SubSpec("تكنولوجيا الملابس"),new SubSpec("التصميم والتطريز"),new SubSpec("ملابس أطفال"),
                new SubSpec("ملابس سهرة"),
                new SubSpec("مصنوعات جلدية"),new SubSpec("ملابس البيت"),new SubSpec("إكسسورات")}),

                new Spec("إدارة المعلومات الصحية",new SubSpec[]{}),new Spec("أرصاد جوية",new SubSpec[]{new SubSpec("الأرصاد السينوبتكية"),new SubSpec("الأرصاد الدينامكية"),
                new SubSpec("الأرصاد الفيزيائية"),new SubSpec("الأرصاد الزراعية"),new SubSpec("أرصاد المناخ"),new SubSpec("أرصاد الطبقة الحدية"),new SubSpec("تنبؤات جوية"),new SubSpec("استشعار عن بعد"),}),

                new Spec("ديبلوماسية",new SubSpec[]{}),new Spec("بحوث العمليات",new SubSpec[]{}),new Spec("تصميم الجرافيك",new SubSpec[]{new SubSpec("الإعلانات"),new SubSpec("تصميم المنشورات"),
                new SubSpec("هوية الشركات"),
                new SubSpec("تصميم الكتب"),new SubSpec("تصميم العلب والكراتين"),new SubSpec("النشر المكتبي"),}),

                new Spec("دعاية وإعلان",new SubSpec[]{}),
                new Spec("إدارة النقل والمواصلات",new SubSpec[]{}),new Spec("الكتابة الإبداعية",new SubSpec[]{new SubSpec("الكتابة الأدبية"),new SubSpec("الكتابة الصحفية"),new SubSpec("كتابة الخيال العلمي"),
                new SubSpec("الكتابة العلمية"),}),

                new Spec("هندسة الصوتيات",new SubSpec[]{}),new Spec("مبادرة الأعمال",new SubSpec[]{}),
                new Spec("الدراسات التكاملية",new SubSpec[]{})};

        MAIN_SPECS[11] = new MainSpec("التخصصات الغير مألوفة",unfamiliarSpec);
        return MAIN_SPECS;
    }


    public static void toastMessageLong(Context context,String str){
        Toast.makeText(context,str,Toast.LENGTH_LONG).show();
    }

    public static void toastMessageShort(Context context , String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }


    //return the screen width of the device
    @SuppressWarnings("deprecation")
    public static double ScWth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        Display display = windowManager.getDefaultDisplay();
        return display.getWidth();
    }

    //----------------------------------------------------------------------------------------------
//public static double ScHgt(Context context)
//----------------------------------------------------------------------------------------------
//return the screen height of the device
    @SuppressWarnings("deprecation")
    public static double ScHgt(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        return display.getHeight();
    }

}
