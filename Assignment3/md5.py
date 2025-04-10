import hashlib

def compute_hashes(text):
    md5_hash = hashlib.md5(text.encode()).hexdigest()
    return md5_hash

user_input = input("Enter a string: ")
md5_result = compute_hashes(user_input)

print(f"MD5 Hash: {md5_result}")