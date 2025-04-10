import hashlib

def compute_hashes(text):
    sha1_hash = hashlib.sha1(text.encode()).hexdigest()
    return sha1_hash

user_input = input("Enter a string: ")
sha1_result = compute_hashes(user_input)

print(f"SHA1 Hash: {sha1_result}")