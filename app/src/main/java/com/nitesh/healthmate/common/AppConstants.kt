package com.faishion.vaama.common

object AppConstants {


    //common app constant
    const val SHARE_PREF_FILE = "app_shared_pref"
    const val IS_LOGGED_IN = "is_active_login"
    const val IMAGE_BYTES_KEY = "imageByteArray"
    const val FULL_SCREEN_PHOTO_KEY = "full_screen_photo_key"
    const val IS_FROM_LOGOUT = "is_for_logout"

    const val DEFAULT_INT = 0

    //user model constants
    const val USER_NAME = "userName"
    const val USER_ID = "userId"
    const val PASSWORD_KEY = "password"
    const val DISPLAY_NAME = "displayName"
    const val EMAIL_KEY = "email"
    const val ROLE_KEY = "role"
    const val MOBILE = "mobile"
    const val IS_ACTIVE = "isActive"

    //role constants
    const val OWNER_KEY = "owner"
    const val CUSTOMER_KEY = "customer"
    const val TAILOR_KEY = "tailor"
    const val HELPER_KEY = "helper"
    const val ORDER_KEY = "order"
    const val DESIGNER_KEY = "designer"

    //collection root paths
    const val USER_ROOT_KEY = "user"
    const val TAILORS_ROOT_KEY = "tailors"
    const val ORDER_ROOT_KEY = "order"
    const val PRODUCT_ROOT_KEY = "product"
    const val CUSTOMER_ROOT_KEY = "customers"
    const val ITEMS_ROOT_KEY = "items"
    const val HELPER_ROOT_KEY = "helper"

    //app data persist constants
    const val USER_DATA = "user_data"
    const val EMPTY_VALUE = ""
    const val SPACE_VALUE = " "
    const val NA_STRING = "N/A"

    //order data constants
    const val PLACED_DATE = "placed_date"
    const val COMPLETED_DATE = "complted_date"
    const val ORDER_DELIVERY_DATE = "order_delivery_date"
    const val CATEGORY = "category"
    const val STATUS = "status"
    const val ORDER_TOTAL = "order_total"
    const val ORDER_PROFIT = "order_profit"
    const val ORDER_ID = "order_id"
    const val CLIENT_NAME = "client_name"
    const val CLIENT_ID = "client_id"
    const val PRODUCT_NAME = "product_name"
    const val PRODUCT_CODE = "product_code"
    const val ORDER_IMAGE_URL = "order_image_url"
    const val COMPLETED_STATUS = "completed"
    const val PENDING_STATUS = "pending"
    const val CANCELED_STATUS = "canceled"
    const val POTENTIAL_STATUS = "potential"
    const val APPAREL_TYPE = "apparel_type"
    const val FABRIC_TYPE = "fabric_type"
    const val FABRIC_COLOR = "fabric_color"
    const val IS_OWN_FABRIC = "is_own_fabric"
    const val MEASUREMENT_DATA = "measurement_data"
    const val DESIGN_PREFERENCE = "design_preference"
    const val TAILORING_STYLE = "tailoring_style"
    const val STANDARD_TAILORING_STYLE = "Standard"
    const val CUSTOM_TAILORING_STYLE = "Custom"
    const val DESIGNER_TAILORING_STYLE = "Designer"
    const val URGENCY_LEVEL = "urgency_level"
    const val STANDARD_URGENCY_LEVEL = "Standard"
    const val EXPRESS_URGENCY_LEVEL = "Express"
    const val FITTING_REQUIRED = "fitting_required"
    const val PRICE_DETAILS = "price_details"
    const val PAYMENT_METHOD = "payment_method"
    const val CASH_PAYMENT_METHOD = "Cash"
    const val UPI_PAYMENT_METHOD = "UPI"
    const val CARD_PAYMENT_METHOD = "Card"
    const val ORDER_STATUS = "order_status"

    const val IS_FOR_REVIEW_ORDER = "is_for_new_order"


    //customer data constants
    const val CLIENT_CONTACT_NUMBER = "client_contact_number"
    const val CLIENT_EMAIL = "client_email"
    const val CLIENT_IMAGE_URL = "client_image_url"
    const val CLIENT_VERIFICATION_URL = "client_verification_url"
    const val CLIENT_IS_VERIFIED = "client_is_verified"
    const val CLIENT_IS_VERIFICATION_BY_REFERENCE = "client_verification_by_reference"
    const val CLIENT_IS_PREMIUM = "client_is_premium"
    const val CLIENT_TOTAL_ORDER = "client_total_orders"
    const val CLIENT_IS_ACTIVE = "client_is_active"

    //tailor data constants
    const val TAILOR_ID = "tailor_id"
    const val TAILOR_NAME = "tailor_name"
    const val TAILOR_PROFILE_URL = "tailor_profile_url"
    const val TAILOR_TOTAL_ORDERS = "tailor_total_orders"
    const val TAILOR_RECENT_ORDER_ID = "tailor_recent_order_id"
    const val TAILOR_CONTACT_NUMBER = "tailor_contact_number"
    const val TAILOR_IS_ACTIVE = "tailor_is_active"
    const val TAILOR_IS_VERIFIED = "tailor_is_verified"
    const val TAILOR_VERIFICATION_URL = "tailor_verification_url"


    //helper data constant
    const val HELPER_ID =  "helper_id"
    const val HELPER_NAME = "helper_name"
    const val HELPER_CONTACT_NUMBER = "helper_contact_number"
    const val HELPER_PROFILE_URL = "helper_profile_url"
    const val HELPER_SALARY = "helper_salary"
    const val HELPER_ALLOWANCE_INVENTORY = "helper_allow_for_inventory"
    const val HELPER_WORK_AREA = "helper_work_area"
    const val HELPER_TASK_DETAILS = "helper_task_details"
    const val HELPER_TASK_STATUS = "helper_task_status"
    const val HELPER_IS_ACTIVE = "helper_is_active"
    const val HELPER_IS_VERIFIED = "helper_is_verified"
    const val HELPER_VERIFICATION_URL = "helper_verification_url"


    //cloundnary configuration

    const val CLOUDNARY_KEY_NAME = "cloud_name"
    const val CLOUDNARY_HOME_NAME = "dsrhe8tmo"
    const val CLOUDNARY_API_KEY_NAME = "api_key"
    const val CLOUDNARY_API_KEY = "215457781324157"
    const val CLOUDNARY_API_SECRET_NAME = "api_secret"
    const val CLOUDNARY_API_SECRET = "H-KSlWy5tePUim6eTRUFlXqRlXs"

    const val PROFILE_IMAGE_ROOT_KEY = "profile_image"
    const val VERIFICATION_IMAGE_ROOT_KEY = "verification_image"
    const val IMAGE_ROOT_URL = "https://res.cloudinary.com/dsrhe8tmo/image/upload/v1737900522/"

    //setting constants
    object AppConfigurationSettings{
        const val APP_UPGRADE_DATE = "appUpgradeDate"
        const val LOGIN_ENABLE = "loginEnable"
        const val APP_ORIENTATION = "orientation"
        const val PRODUCT_ENABLE = "productEnable"
        const val ERROR_TITLE = "errorTitle"
        const val ERROR_MESSAGE = "errorMessage"
        const val CONTACT_NUMBER = "contactNumber"
        const val INSTA_USER_NAMW = "instagramUserName"
        const val APP_CONFIG_PATH_KEY = "appconfig"
        const val APP_CONFIG_REF_KEY = "appconfiguration"
        const val APP_CONFIG_KEY = "app_config_key"
    }


    object AppOrientation{

         val ORIENTATION_POTRAIT = "potrait"
         val ORIENTATION_LANDSCAPE = "landcsape"
         val ORIENTATION_UNSPECIFCIFIED = "unspecified"

    }

}