from flask import Flask, jsonify, current_app
from config import get_db_connection

app = Flask(__name__)

app.database = get_db_connection()  # 데이터 베이스와 연동해준다.

def get_user(user_id):
    sql = f"""
        SELECT 
            *
        FROM credit_info
        WHERE user_id = "{user_id}"
    """
    user = current_app.database.execute(sql).fetchone()

    return {'user_id': user['user_id'],
                '세금납세이행여부': user['pay_tax_yn'],
                '4대보험 가입 여부' :
                     {'국민연금': user['national_pension'],
                      '건강보험': user['health_insurance'],
                      '고용보험': user['employment_insurance'],
                      '산재보험': user['work_insurance']
                      },
                '재직증명서' :
                    {
                    '직업': user['job'],
                    '근속년수': user['work_year'],
                     '기업명': user['company_name'],
                     '상장여부': user['ipo_yn'],
                    }}

@app.route("/credit_auth_info/<user_id>", methods=['GET'])
def get_user_info(user_id):
    user_info = get_user(user_id)
    return jsonify(user_info)

@app.route("/")
def main():
    return '/credit_auth_info/<user_id> 입력하기'

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000, debug=True)