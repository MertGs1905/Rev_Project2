import { UserProfile } from './Profile';

export interface IUser {
    profile: UserProfile;
    password: string;
    username: string;
    user_id: number;
}
